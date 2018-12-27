package com.dwms.course.mgr.impl;

import com.dwms.common.exception.MgrException;
import com.dwms.course.consts.CourseConsts;
import com.dwms.course.dao.ICourseChapterDAO;
import com.dwms.course.dao.ICourseChapterUserDAO;
import com.dwms.course.dao.ICourseDAO;
import com.dwms.course.dao.ICourseUserDAO;
import com.dwms.course.mgr.IChapterMgr;
import com.dwms.course.model.bean.Course;
import com.dwms.course.model.bean.CourseChapterUser;
import com.dwms.course.model.bean.CourseUser;
import com.dwms.course.model.form.SyncForm;
import com.dwms.course.model.vo.ChapterVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 微党课章节通用层
 * @author windy
 * @date 2018-12-10
 */
@Component
public class ChapterMgr implements IChapterMgr {

    @Resource
    private ICourseChapterDAO courseChapterDAO;
    @Resource
    private ICourseChapterUserDAO courseChapterUserDAO;
    @Resource
    private ICourseUserDAO courseUserDAO;
    @Resource
    private ICourseDAO courseDAO;

    @Override
    @Async
    public void updateProgress(SyncForm form) {
        //章节阅读信息
        List<ChapterVO> cs = courseChapterDAO.selectMy(form);
        if (CollectionUtils.isEmpty(cs)) {
            throw new MgrException("微党课章节信息不存在");
        }

        //微党课
        int courseId = cs.get(0).getCourseId();
        Course course = courseDAO.selectByPrimaryKey(courseId);
        if (course == null) {
            throw new MgrException("微党课课程不存在");
        }

        //微党课用户记录
        CourseUser cu = courseUserDAO.selectByCourseIdAndUserId(courseId, form.getUserId());

        int timeLength = cu.getTimeLength() + form.getMin();
        int restChapter = course.getChapterNum();
        int progressTime = 0;

        //章节阅读信息
        CourseChapterUser ccu = new CourseChapterUser();
        for (ChapterVO c : cs) {
            if (c.getChapterId().equals(form.getChapterId())) {
                int status = form.getMin() + c.getUserTimeLength() >= c.getTimeLength() ? CourseConsts.CHAPTERUSER_STATUS_FINISH : CourseConsts.CHAPTERUSER_STATUS_GOING;
                if (c.getCcuId() == null) {
                    ccu.setChapterId(c.getChapterId());
                    ccu.setUserId(form.getUserId());
                    ccu.setTimeLength(form.getMin());
                    ccu.setStatus(status);
                    if (status == CourseConsts.CHAPTERUSER_STATUS_FINISH) {
                        ccu.setFinishTime(new Date());
                    }
                    courseChapterUserDAO.insertSelective(ccu);
                } else {
                    ccu.setCcuId(c.getCcuId());
                    ccu.setTimeLength(c.getUserTimeLength() + form.getMin());
                    ccu.setStatus(status);
                    if (status == CourseConsts.CHAPTERUSER_STATUS_FINISH) {
                        ccu.setFinishTime(new Date());
                    }
                    courseChapterUserDAO.updateByPrimaryKeySelective(ccu);
                }
                c.setStatus(status);
            }

            //计算进度时间
            if (c.getStatus() == CourseConsts.CHAPTERUSER_STATUS_FINISH) {
                progressTime += c.getTimeLength();
                restChapter--;
            } else {
                progressTime += c.getUserTimeLength();
            }
        }

        //微党课阅读信息
        cu.setTimeLength(timeLength);
        if (restChapter == 0) {
            cu.setStatus(CourseConsts.USER_STATUS_FINISH);
            cu.setFinishTime(new Date());
            cu.setProgress(100);
        } else {
            cu.setStatus(CourseConsts.USER_STATUS_GOING);
            cu.setProgress(progressTime * 100 / course.getTimeLength());
        }
        cu.setRestChapter(restChapter);
        courseUserDAO.updateByPrimaryKeySelective(cu);
    }
}

package com.dwms.course.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.course.model.bean.CourseChapter;
import com.dwms.course.model.form.DetailForm;
import com.dwms.course.model.form.SyncForm;
import com.dwms.course.model.vo.ChapterVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微课程章节DAO接口
 * @author windy
 * @date 2018-12-06
 */
public interface ICourseChapterDAO extends BaseMapper<CourseChapter> {

    /**
     * 微党课章节阅读信息
     * @author windy
     * @date 2018-12-10
     */
    ChapterVO selectByChapterIdAndUserId(@Param("chapterId") Integer chapterId, @Param("userId") String userId);

    /**
     * 课程章节form
     * @author windy
     * @date 2018-12-10
     */
    List<ChapterVO> selectDetail(@Param("form") DetailForm form);

    /**
     * 课程章节阅读列表
     * @author windy
     * @date 2018-12-10
     */
    List<ChapterVO> selectMy(@Param("form") SyncForm form);
}

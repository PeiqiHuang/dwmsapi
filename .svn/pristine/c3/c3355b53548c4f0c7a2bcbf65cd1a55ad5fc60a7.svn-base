package com.dwms.examine.service.impl;

import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.examine.consts.ExamineConsts;
import com.dwms.examine.dao.*;
import com.dwms.examine.model.bean.Examine;
import com.dwms.examine.model.bean.ExamineQuestionUser;
import com.dwms.examine.model.bean.ExamineUser;
import com.dwms.examine.model.form.AnswerForm;
import com.dwms.examine.model.form.ListForm;
import com.dwms.examine.model.form.SaveAnswerForm;
import com.dwms.examine.model.vo.*;
import com.dwms.examine.service.IExamineService;
import com.dwms.user.dao.IUserDAO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 考试服务
 * @author windy
 * @date 2018-12-14
 */
@Service
public class ExamineService implements IExamineService {

    @Resource
    private IUserDAO userDAO;
    @Resource
    private IExamineDAO examineDAO;
    @Resource
    private IExamineUserDAO examineUserDAO;
    @Resource
    private IExamineQuestionDAO examineQuestionDAO;
    @Resource
    private IExamineQuestionUserDAO examineQuestionUserDAO;
    @Resource
    private IQuestionDAO questionDAO;


    @Override
    public ResultBean getDetail(Integer euId) {
        ExamineVO e = examineDAO.selectByEuId(euId);
        if (e == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考卷不存在");
        }

        List<QuestionVO> qs = examineQuestionDAO.selectQuestion(e.getExamId());
        Map<String, Object> data = Maps.newHashMap();
        data.put(ExamineConsts.EXAMINE, e);
        data.put("questions", qs);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean list(Page<ExamineVO> page, ListForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> examineDAO.selectSelective(form));

        //考试人数
        if (!page.isEmpty()) {
            List<ExamineVO> es = page.getResult();
            List<Integer> examIds = Lists.newArrayList();
            for (ExamineVO e : es) {
                examIds.add(e.getExamId());
            }

            List<CountVO> cs = examineUserDAO.countByExamIds(examIds);
            for (ExamineVO e : es) {
                for (CountVO c : cs) {
                    if (e.getExamId().equals(c.getExamId())) {
                        e.setNums(c.getNums());
                        break;
                    }
                }
                if (e.getNums() == null) {
                    e.setNums(0);
                }
            }
        }

        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean getAnswer(AnswerForm form) {
        Examine e = examineDAO.selectByEuId(form.getEuId());
        if (e == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试不存在");
        } else if (ExamineConsts.STATUS_CLOSE == e.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试已删除");
        } else if (e.getBeginTime().getTime() > System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试未开始");
        }

        ExamineUser eu = examineUserDAO.selectByPrimaryKey(form.getEuId());
        if (eu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户不能参加改考试");
        } else if (!eu.getUserId().equals(form.getUserId())) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户无权查看答案");
        } else if (ExamineConsts.USER_STATUS_NOTSTART == eu.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户未提交答案");
        }

        List<AnswerVO> answers = examineQuestionUserDAO.selectAnswer(e.getExamId(), form.getEuId());
        for (AnswerVO a : answers) {
            if (StringUtils.isNotBlank(a.getAnswer())) {
                switch (a.getQuType()) {
                    case ExamineConsts.QUESTION_QUTYPE_SINGLE:
                    case ExamineConsts.QUESTION_QUTYPE_MULTI:
                        a.setAnswer(ExamineUtils.simpleAnswer(a.getAnswer()));
                        break;
                    default:
                        break;
                }
            }
        }

        //抽取信息
        ScoreVO score = new ScoreVO();
        score.setEuId(eu.getEuId());
        score.setExamId(e.getExamId());
        score.setUserId(eu.getUserId());
        score.setScore(eu.getScore());
        score.setPassScore(e.getPassScore());
        score.setUseTimeLength(eu.getTimeLength());
        score.setStatus(eu.getStatus());//状态 0未通过 1待判分 2已通过

        Map<String, Object> data = Maps.newHashMap();
        data.put("score", score);
        data.put("answers", answers);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean saveAnswer(SaveAnswerForm form) {
        //参与情况
        ExamineUser eu = examineUserDAO.selectByPrimaryKey(form.getEuId());
        if (eu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户不能参加改考试");
        } else if (!eu.getUserId().equals(form.getUserId())) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户不能参加改考试");
        } else if (ExamineConsts.USER_STATUS_NOTSTART != eu.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户已提交答案");
        }

        //考试信息
        Examine e = examineDAO.selectByPrimaryKey(eu.getExamId());
        if (e == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试不存在");
        } else if (e.getBeginTime().getTime() > System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试未开始");
        } else if (e.getEndTime().getTime() < System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试已结束");
        } else if (e.getTimeLength() * 60 < form.getTimeLength()) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "考试超时");
        }

        //正确答案
        List<QuestionVO> answers = examineQuestionDAO.selectAnswer(e.getExamId());
        if (CollectionUtils.isEmpty(answers)) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试异常");
        }

        List<ExamineQuestionUser> submitEqus = form.getAnswers();//提交答案
        submitEqus.remove(new ExamineQuestionUser());//删除空答案
        List<ExamineQuestionUser> saveEqus = Lists.newArrayList();//提交答案
        int totalScore = 0;//总得分
        int status = eu.getStatus();

        //问题分数
        for (QuestionVO answer : answers) {
            ExamineQuestionUser que = new ExamineQuestionUser();
            que.setEqId(answer.getEqId());
            que.setEuId(form.getEuId());
            que.setScore(0);
            que.setStatus(ExamineConsts.QUESTION_USER_STATUS_ERROR);

            for (ExamineQuestionUser submit : submitEqus) {
                if (submit.getEqId().equals(answer.getEqId())) {
                    switch (answer.getQuType()) {
                        case ExamineConsts.QUESTION_QUTYPE_SINGLE:
                        case ExamineConsts.QUESTION_QUTYPE_MULTI:
                            que.setAnswer(ExamineUtils.choiceAnswer(submit.getAnswer(), answer.getAnswers()));
                            if (answer.getRightKey().equals(que.getAnswer())) {
                                que.setScore(answer.getScore());
                                que.setStatus(ExamineConsts.QUESTION_USER_STATUS_SUCCESS);
                            }
                            break;
                        case ExamineConsts.QUESTION_QUTYPE_BLANK:
                            que.setAnswer(submit.getAnswer());
                            if (answer.getRightKey().equals(que.getAnswer())) {
                                que.setScore(answer.getScore());
                                que.setStatus(ExamineConsts.QUESTION_USER_STATUS_SUCCESS);
                            }
                            break;
                        case ExamineConsts.QUESTION_QUTYPE_ANSWER:
                            que.setStatus(ExamineConsts.QUESTION_USER_STATUS_WAITING);
                            status = ExamineConsts.USER_STATUS_WAITING;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (que.getScore() == null) {
                que.setScore(0);
            }
            saveEqus.add(que);
            totalScore += que.getScore();
        }

        examineQuestionUserDAO.insertList(saveEqus);

        //保存总成绩
        eu.setScore(totalScore);
        eu.setTimeLength(form.getTimeLength());
        eu.setFinishTime(new Date());
        if (status != ExamineConsts.USER_STATUS_WAITING) {
            status = totalScore >= e.getPassScore() ? ExamineConsts.USER_STATUS_SUCCESS : ExamineConsts.USER_STATUS_FAIL;
        }
        eu.setStatus(status);
        eu.setCreateTime(null);
        examineUserDAO.updateByPrimaryKeySelective(eu);

        return ResultUtils.successBean();
    }


}

/**
 * 考试工具类
 * @author windy
 * @date 2018-12-18
 */
class ExamineUtils {

    /**
     * 完善用户答案
     * @author windy
     * @date 2018-12-18
     */
    public static String choiceAnswer(String userAnswer, String answer) {
        if (StringUtils.isAnyBlank(userAnswer, answer)) {
            return null;
        }

        String[] options = answer.split(ExamineConsts.SPLIT_OPTION);
        Arrays.sort(options);
        String[] userAnswers = userAnswer.split(ExamineConsts.SPLIT_OPTION);

        //拼接答案
        StringBuilder sb = new StringBuilder();
        for (String option : options) {
            String prefix = null;
            for (String ua : userAnswers) {
                prefix = ua + ExamineConsts.SPLIT_SERIAL;
                if (option.startsWith(prefix)) {
                    sb.append(option).append(ExamineConsts.SPLIT_OPTION);
                    break;
                }
            }
        }

        String result = sb.toString();
        if (result.endsWith(ExamineConsts.SPLIT_OPTION)) {
            return result.substring(0, result.length() - ExamineConsts.SPLIT_OPTION.length());
        }

        return result;
    }

    /**
     * 简化用户答案
     * @author windy
     * @date 2018-12-18
     */
    public static String simpleAnswer(String userAnswer) {
        if (StringUtils.isBlank(userAnswer)) {
            return null;
        }

        String[] userAnswers = userAnswer.split(ExamineConsts.SPLIT_OPTION);

        //拼接答案
        StringBuilder sb = new StringBuilder();
        for (String ua : userAnswers) {
            String[] strs=ua.split(ExamineConsts.SPLIT_SERIAL);
            sb.append(strs[0]).append(ExamineConsts.SPLIT_OPTION);
        }
        String result = sb.toString();
        if (result.endsWith(ExamineConsts.SPLIT_OPTION)) {
            return result.substring(0, result.length() - ExamineConsts.SPLIT_OPTION.length());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(simpleAnswer("B|||不不不===C|||戳戳戳"));
    }
}

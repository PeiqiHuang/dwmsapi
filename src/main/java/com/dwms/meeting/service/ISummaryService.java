package com.dwms.meeting.service;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.model.ResultBean;
import com.dwms.meeting.model.form.DelSummaryForm;
import com.dwms.meeting.model.form.ReadForm;
import com.dwms.meeting.model.form.SaveSummaryForm;
import com.dwms.meeting.model.form.UpdSummaryForm;
import com.dwms.meeting.model.vo.SummaryVO;
import com.github.pagehelper.Page;

/**
 * 会议纪要服务
 * @author windy
 * @date 2018-12-04
 */
public interface ISummaryService {

    /**
     * 纪要详情
     * @author windy
     * @date 2018-12-05
     */
    ResultBean getDetail(Integer sumId);

    /**
     * 相关纪要
     * @author windy
     * @date 2018-12-04
     */
    ResultBean getRelation(Page<SummaryVO> page, UserIdForm form);

    /**
     * 发布纪要列表
     * @author windy
     * @date 2018-12-04
     */
    ResultBean getRelease(Page<SummaryVO> page, UserIdForm form);

    /**
     * 对应会议列表
     * @author windy
     * @date 2018-12-05
     */
    ResultBean getRecorder(UserIdForm form);

    /**
     * 保存纪要
     * @author windy
     * @date 2018-12-04
     */
    ResultBean save(SaveSummaryForm form);

    /**
     * 修改纪要
     * @author windy
     * @date 2018-12-04
     */
    ResultBean upd(UpdSummaryForm form);

    /**
     * 删除纪要
     * @author windy
     * @date 2018-12-04
     */
    ResultBean del(DelSummaryForm form);

    /**
     * 已读
     * @author windy
     * @date 2018-12-05
     */
    ResultBean updRead(ReadForm form);
}

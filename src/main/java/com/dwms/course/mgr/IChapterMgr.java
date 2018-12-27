package com.dwms.course.mgr;

import com.dwms.course.model.form.SyncForm;
import org.springframework.scheduling.annotation.Async;

/**
 * 课程通用层
 * @author windy
 * @date 2018-12-10
 */
public interface IChapterMgr {

    /**
     * 更新进度
     * @author windy
     * @date 2018-12-10
     */
    @Async
    void updateProgress(SyncForm form);
}

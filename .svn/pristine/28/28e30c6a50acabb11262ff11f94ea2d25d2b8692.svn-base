package com.dwms.common.util.path;

import com.dwms.activity.model.bean.Activity;
import com.dwms.activity.model.vo.ActivityVO;
import com.dwms.common.config.SysConfig;
import com.dwms.common.util.SpringUtils;
import com.dwms.meeting.model.vo.SummaryVO;
import com.dwms.news.model.bean.NewsBuild;
import com.dwms.notice.model.bean.Notice;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * html工具类
 * @author windy
 * @date 2018-11-26
 */
public class HtmlUtils {

    //静态获取系统配置
    private static final SysConfig sysConfig = SpringUtils.getBean(SysConfig.class);

    /**
     * 会议纪要html文件
     * @author windy
     * @date 2018-11-26
     */
    public static SummaryVO summary(SummaryVO s) {
        if (s != null) {
            if (StringUtils.isNotBlank(s.getFilePath())) {
                s.setFilePath(sysConfig.getAccessPath() + s.getFilePath());
            }
        }
        return s;
    }

    /**
     * 会议纪要html文件
     * @author windy
     * @date 2018-11-26
     */
    public static List<SummaryVO> summary(List<SummaryVO> ss) {
        if (!CollectionUtils.isEmpty(ss)) {
            for (SummaryVO s : ss) {
                if (StringUtils.isNotBlank(s.getFilePath())) {
                    s.setFilePath(sysConfig.getAccessPath() + s.getFilePath());
                }
            }
        }
        return ss;
    }

    /**
     * 活动html文件
     * @author windy
     * @date 2018-11-26
     */
    public static Activity activity(Activity a) {
        if (a != null) {
            if (StringUtils.isNotBlank(a.getFilePath())) {
                a.setFilePath(sysConfig.getAccessPath() + a.getFilePath());
            }
        }
        return a;
    }

    /**
     * 活动html文件
     * @author windy
     * @date 2018-11-26
     */
    public static List<ActivityVO> activity(List<ActivityVO> as) {
        if (!CollectionUtils.isEmpty(as)) {
            for (ActivityVO a : as) {
                if (StringUtils.isNotBlank(a.getFilePath())) {
                    a.setFilePath(sysConfig.getAccessPath() + a.getFilePath());
                }
            }
        }
        return as;
    }

    /**
     * 通知公告html文件
     * @author windy
     * @date 2018-11-26
     */
    public static List<Notice> notice(List<Notice> ns) {
        if (!CollectionUtils.isEmpty(ns)) {
            for (Notice n : ns) {
                if (StringUtils.isNotBlank(n.getFilePath())) {
                    n.setFilePath(sysConfig.getAccessPath() + n.getFilePath());
                }
            }
        }
        return ns;
    }

    /**
     * 党建要闻列表
     * @author windy
     * @date 2018-11-26
     */
    public static List<NewsBuild> newsBuild(List<NewsBuild> ns) {
        if (!CollectionUtils.isEmpty(ns)) {
            for (NewsBuild n : ns) {
                if (StringUtils.isNotBlank(n.getFilePath())) {
                    n.setFilePath(sysConfig.getAccessPath() + n.getFilePath());
                }
            }
        }
        return ns;
    }
}
package com.dwms.common.util.path;

import com.dwms.common.config.SysConfig;
import com.dwms.common.util.SpringUtils;
import com.dwms.course.model.vo.CourseVO;
import com.dwms.course.model.vo.DetailVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * txt工具类
 * @author windy
 * @date 2018-12-06
 */
public class TxtUtils {

    //静态获取系统配置
    private static final SysConfig sysConfig = SpringUtils.getBean(SysConfig.class);

    /**
     * 微课程txt文件
     * @author windy
     * @date 2018-11-26
     */
    public static List<CourseVO> course(List<CourseVO> cs) {
        if (!CollectionUtils.isEmpty(cs)) {
            for (CourseVO c : cs) {
                if (StringUtils.isNotBlank(c.getFilePath())) {
                    c.setFilePath(sysConfig.getAccessPath() + c.getFilePath());
                }
            }
        }
        return cs;
    }

    /**
     * 微课程章节txt文件
     * @author windy
     * @date 2018-11-26
     */
    public static DetailVO course(DetailVO c) {
        if (c != null) {
            if (StringUtils.isNotBlank(c.getFilePath())) {
                c.setFilePath(sysConfig.getAccessPath() + c.getFilePath());
            }
        }
        return c;
    }
}

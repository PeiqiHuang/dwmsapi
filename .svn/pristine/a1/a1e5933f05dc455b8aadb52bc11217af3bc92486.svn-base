package com.dwms.common.util;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 * @author windy
 * @date 2018-11-16
 */
public class PageUtils {

    /**
     * 分页数据转换
     * @author windy
     * @date 2018-11-16
     */
    public static Map<String, Object> map(Page<?> page) {
        Map<String, Object> data = new HashMap<String, Object>(2);
        data.put("objs", page.getResult());

        //分页信息
        if (page.getPageNum() > 0 && page.getPageSize() > 0 && page.getTotal() > -1) {
            Map<String, Object> pm = new HashMap<String, Object>(4);
            pm.put("pageNum", page.getPageNum());
            pm.put("pageSize", page.getPageSize());
            pm.put("totalPage", page.getPages());
            pm.put("totalNum", page.getTotal());
            data.put("page", pm);
        }
        return data;
    }
}

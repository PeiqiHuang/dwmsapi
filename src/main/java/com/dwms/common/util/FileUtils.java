package com.dwms.common.util;

import com.dwms.common.consts.SysConsts;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 * @author windy
 * @date 2018-12-04
 */
@Slf4j
public class FileUtils {

    /**
     * 保存文件
     * @param content  保存内容
     * @param basePath 基础路径
     * @param fileName 文件名
     * @author windy
     * @date 2018-12-04
     */
    public static boolean save(String content, String basePath, String fileName) {
        try {
            org.apache.commons.io.FileUtils.writeStringToFile(new File(basePath + fileName), content, SysConsts.CHARSET);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取文件名
     * @param path 完整路径名
     * @author windy
     * @date 2018-12-04
     */
    public static String name(String path) {
        if (path == null || "".equals(path)) {
            return null;
        }

        int lastIndex = path.lastIndexOf("/");
        if (lastIndex > -1) {
            return path.substring(lastIndex);
        }
        return path;
    }
}

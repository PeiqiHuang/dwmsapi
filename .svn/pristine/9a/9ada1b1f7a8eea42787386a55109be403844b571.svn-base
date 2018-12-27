package com.dwms.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应工具类
 * @author 罗俊标
 * @date 2016-7-28
 */
public class ResponseUtils {

    // 输出响应
    public static void responseToWrite(HttpServletResponse response, String msg) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.write(msg);
        pw.flush();
        pw.close();
    }
}
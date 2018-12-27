package com.dwms.course.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 课程接口测试
 * @author windy
 * @date 2018-12-07
 */
@Profile("dev")
public class CourseAPI extends APITest {

    /**
     * 课程详情
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testDetail() {
        String url = PREFIX + "/course/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("courseId", "37");//课程id

        //选填参数
//        param.put("chapterType", "1");//章节类型 1章 2节

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 课程列表
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testList() {
        String url = PREFIX + "/course/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
        //        param.put("courseType", "0");//类型 0选修 1必修，不传查询所有
        //        param.put("pageNum", "1");//分页页码，不传查询全部
        //        param.put("pageSize", "10");//分页显示数，不传查询全部

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 我的课程
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testMy() {
        String url = PREFIX + "/course/my.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
        //        param.put("status", "0");//状态 0未完成 1已完成，不传查询所有
        //        param.put("pageNum", "1");//分页页码，不传查询全部
        //        param.put("pageSize", "10");//分页显示数，不传查询全部

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 加入学习
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testLearn() {
        String url = PREFIX + "/course/learn.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("courseId", "28");//课程id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 更新进度
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testProgress() {
        String url = PREFIX + "/course/progress.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("chapterId", "462");//章节id
        param.put("min", "100");//已读分钟

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

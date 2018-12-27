package com.dwms.common.util.path;

import com.dwms.album.model.bean.AlbumImg;
import com.dwms.album.model.vo.AlbumVO;
import com.dwms.base.model.vo.AdvertVO;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.util.SpringUtils;
import com.dwms.course.model.vo.CourseVO;
import com.dwms.course.model.vo.DetailVO;
import com.dwms.due.model.bean.DueAccount;
import com.dwms.due.model.bean.DueUser;
import com.dwms.notice.model.bean.Notice;
import com.dwms.user.model.vo.UserVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 封面图片设置工具类
 * @author windy
 * @date 2018-11-26
 */
public class CoverUtils {

    private static final String JPG = ".jpg";//图片后缀类型
    private static final String PNG = ".png";//图片后缀类型
    private static final String TIMESTAMP = "?timestamp=";//图片时间戳
    //静态获取图片配置
    private static final ImageConfig imageConfig = SpringUtils.getBean(ImageConfig.class);

    /**
     * 广告图片设置
     * @author windy
     * @date 2018-11-26
     */
    public static List<AdvertVO> advert(List<AdvertVO> as) {
        if (!CollectionUtils.isEmpty(as)) {
            for (AdvertVO a : as) {
                Integer actId = a.getAdId();
                a.setCover(imageConfig.getAccessPath() + "/" + actId + JPG);
            }
        }
        return as;
    }

    /**
     * 用户头像设置
     * @author windy
     * @date 2018-11-26
     */
    public static UserVO userAvatar(UserVO u) {
        if (u != null) {
            if (StringUtils.isNotBlank(u.getAvatar())) {
                u.setAvatar(imageConfig.getAccessPath() + u.getAvatar());
            }
        }
        return u;
    }

    /**
     * 用户头像设置
     * @author windy
     * @date 2018-11-26
     */
    public static List<UserVO> userAvatar(List<UserVO> us) {
        if (!CollectionUtils.isEmpty(us)) {
            for (UserVO u : us) {
                if (StringUtils.isNotBlank(u.getAvatar())) {
                    u.setAvatar(imageConfig.getAccessPath() + u.getAvatar());
                }
            }
        }
        return us;
    }

    /**
     * 微课程封面设置
     * @author windy
     * @date 2018-11-26
     */
    public static List<CourseVO> course(List<CourseVO> cs) {
        if (!CollectionUtils.isEmpty(cs)) {
            for (CourseVO c : cs) {
                if (StringUtils.isNotBlank(c.getCover())) {
                    c.setCover(imageConfig.getAccessPath() + c.getCover());
                }
            }
        }
        return cs;
    }

    /**
     * 微课程封面设置
     * @author windy
     * @date 2018-11-26
     */
    public static DetailVO courseBanner(DetailVO c) {
        if (c != null) {
            if (StringUtils.isNotBlank(c.getBanner())) {
                c.setBanner(imageConfig.getAccessPath() + c.getBanner());
            }
        }
        return c;
    }

    /**
     * 通知公告封面设置
     * @author windy
     * @date 2018-11-26
     */
    public static List<Notice> notice(List<Notice> ns) {
        if (!CollectionUtils.isEmpty(ns)) {
            for (Notice n : ns) {
                if (StringUtils.isNotBlank(n.getCover())) {
                    n.setCover(imageConfig.getAccessPath() + n.getCover());
                }
            }
        }
        return ns;
    }

    /**
     * 党建相册封面
     * @author windy
     * @date 2018-11-26
     */
    public static List<AlbumVO> album(List<AlbumVO> as) {
        if (!CollectionUtils.isEmpty(as)) {
            for (AlbumVO a : as) {
                if (StringUtils.isNotBlank(a.getCover())) {
                    a.setCover(imageConfig.getAccessPath() + a.getCover());
                }
            }
        }
        return as;
    }

    /**
     * 党建相册列表
     * @author windy
     * @date 2018-11-26
     */
    public static List<AlbumImg> albumImg(List<AlbumImg> as) {
        if (!CollectionUtils.isEmpty(as)) {
            for (AlbumImg a : as) {
                if (StringUtils.isNotBlank(a.getImgPath())) {
                    a.setImgPath(imageConfig.getAccessPath() + a.getImgPath());
                }
            }
        }
        return as;
    }

    /**
     * 党费缴费信息
     * @author windy
     * @date 2018-11-26
     */
    public static DueUser dueUser(DueUser du) {
        if (du != null) {
            if (StringUtils.isNotBlank(du.getImgPath())) {
                du.setImgPath(imageConfig.getAccessPath() + du.getImgPath());
            }
        }
        return du;
    }

    /**
     * 党费账户
     * @author windy
     * @date 2018-11-26
     */
    public static DueAccount dueAccount(DueAccount da) {
        if (da != null) {
            if (StringUtils.isNotBlank(da.getAlipayFilePath())) {
                da.setAlipayFilePath(imageConfig.getAccessPath() + da.getAlipayFilePath());
            }
            if (StringUtils.isNotBlank(da.getWechatFilePath())) {
                da.setWechatFilePath(imageConfig.getAccessPath() + da.getWechatFilePath());
            }
        }
        return da;
    }

}
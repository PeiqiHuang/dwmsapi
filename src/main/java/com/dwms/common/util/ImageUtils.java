package com.dwms.common.util;

import com.dwms.common.config.ImageConfig;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 图片操作工具类
 * @author windy
 * @date 2016-12-15
 */
public class ImageUtils {

    public static final String JPG = ".jpg";//图片后缀类型
    private static List<String> IMAGE_TYPES = SpringUtils.getBean(ImageConfig.class).getImageTypes();

    /**
     * 保存图片
     * @param file 文件
     * @param path 保存路径
     * @param name 图片名
     * @author windy
     * @date 2016-12-15
     */
    public static boolean save(MultipartFile file, String path, String name) {
        File temp = new File(path + name);
        if (!temp.getParentFile().exists()) {
            temp.getParentFile().mkdirs();
        }

        try {
            if (!temp.exists()) {
                boolean ok = temp.createNewFile();
                if (!ok) {
                    return false;
                }
            }
            //传输图片
            file.transferTo(temp);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断图片是否是常见的类型
     * @author windy
     * @date 2016-12-16
     */
    public static boolean type(String type) {
        if (type == null || "".equals(type)) {
            return false;
        }

        String imageType = type.contains("image/") ? type.substring(type.indexOf("image/") + 6) : type;

        if (IMAGE_TYPES.contains(imageType.toLowerCase())) {
            return true;
        }

        return false;
    }

    /**
     * 图片格式转换
     * @author windy
     * @date 2017-06-10
     */
    public static boolean converter(File imgSrc, String typeDes, File imgDes) {
        try {
            //类型相同，不转换
            if (imgSrc.getName().equals(imgDes.getName())) {
                return true;
            }
            BufferedImage image = ImageIO.read(imgSrc);
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            //Color.WHITE estes the background to white. You can use any other color
            g.drawImage(image, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), Color.WHITE, null);
            ImageIO.write(bufferedImage, typeDes, imgDes);
            imgSrc.deleteOnExit();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 图片格式转换保存
     * @param file 文件
     * @param path 保存路径
     * @param name 文件名
     * @param type 类型名称
     * @author windy
     * @date 2017-06-10
     */
    public static boolean save(MultipartFile file, String path, String name, String type) {
        //类型判断
        String fileType = file.getContentType();
        String imageType = fileType.contains("image/") ? fileType.substring(type.indexOf("image/") + 7) : fileType;
        imageType = imageType.toLowerCase();

        if (!IMAGE_TYPES.contains(imageType)) {
            return false;
        }

        //保存图片
        boolean isSave = ImageUtils.save(file, path, name + "." + imageType);
        if (!isSave) {
            return false;
        }

        File imgSrc = new File(path + "/" + name + "." + imageType);
        File imgDes = new File(path + "/" + name + "." + type);

        //转换图片
        return converter(imgSrc, type, imgDes);
    }


}
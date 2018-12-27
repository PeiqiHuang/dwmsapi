package com.dwms.common.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * AES加密工具类
 * @author windy
 * @date 2018-11-08
 */
public class AESUtils {

    private static final String KEY = "s4sdf3hozior55da";//默认密钥
    private static final String ALGORITHM = "AES";//AES加密算法
    private static final String AESTYPE = "AES/ECB/PKCS5Padding";//加密算法类型
    private static final String CHARSET = "utf-8";//默认编码
    private static final String HEX_NUMS_STR = "0123456789abcdef";//16进制字符串

    /**
     * 加密字符串
     * @param value      加密内容
     * @param encryptKey 密钥
     */
    public static String encrypt(String value, String encryptKey) {
        byte[] bytes;
        try {
            Key key = new SecretKeySpec(encryptKey.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            bytes = cipher.doFinal(value.getBytes(CHARSET));
            return byteToHex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     * @param value      解密字节
     * @param decryptKey 密钥
     */
    public static String decrypt(String value, String decryptKey) {
        byte[] decrypt = null;
        try {
            Key key = new SecretKeySpec(decryptKey.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(hexToByte(value));
            return new String(decrypt, CHARSET).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将16进制字符串转换成字节数组
     */
    private static byte[] hexToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    /**
     * 将指定byte数组转换成16进制字符串
     */
    private static String byteToHex(byte[] b) {
        StringBuilder hexString = new StringBuilder();
        for (byte aB : b) {
            String hex = Integer.toHexString(aB & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toLowerCase());
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String encrypt = encrypt("a12345678", "s4sdf3hozior55da");
        System.out.println(encrypt);
        System.out.println(decrypt(encrypt, "s4sdf3hozior55da"));
    }
}
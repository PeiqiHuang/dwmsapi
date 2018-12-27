package com.dwms.common.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * DES加密工具类
 * @author windy
 * @date 2018-11-08
 */
public class DESUtils {

    private final static String KEY = "ScAKC0XhadTHT3Al0QIDAQAB";//默认密钥
    private static final String ALGORITHM = "DES";//DES加密算法
    private static final String CHARTSET = "utf-8";//默认编码
    private static Key key;//工具静态key

    /**
     * DES加密
     * @param value 加密内容
     * @param key   密钥
     */
    public static String encrypt(String value, String key) {
        String encryptedData = null;
        try {
            DESKeySpec deskey = new DESKeySpec(key.getBytes());
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, factory.generateSecret(deskey), new SecureRandom());
            encryptedData = Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes(CHARTSET)));
        } catch (Exception e) {
            throw new RuntimeException("DES加密错误，错误信息：", e);
        }
        return encryptedData;
    }

    /**
     * DES解密
     * @param value 解密内容
     * @param key   密钥
     */
    public static String decrypt(String value, String key) {
        String decryptedData = null;
        try {
            DESKeySpec deskey = new DESKeySpec(key.getBytes());
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, factory.generateSecret(deskey), new SecureRandom());
            decryptedData = new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        } catch (Exception e) {
            throw new RuntimeException("DES解密错误，错误信息：", e);
        }
        return decryptedData;
    }

    /**
     * 根据参数生成key
     * @param strKey 密钥
     */
    public static void getKey(String strKey) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(strKey.getBytes());
            //_generator.init(new SecureRandom(strKey.getBytes()));Linux下会报错
            keyGenerator.init(random);
            key = keyGenerator.generateKey();
            keyGenerator = null;
        } catch (Exception e) {
            throw new RuntimeException("DES生成key，错误信息：", e);
        }
    }

    /**
     * DES加密字节
     * @param encryptBytes 加密字节
     */
    private static byte[] encryptToBytes(byte[] encryptBytes) {
        byte[] result = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            result = cipher.doFinal(encryptBytes);
        } catch (Exception e) {
            throw new RuntimeException("DES加密字节错误，错误信息：", e);
        }
        return result;
    }

    /**
     * DES解密字节
     * @param decryptBytes 解密字节
     */
    private static byte[] decryptToBytes(byte[] decryptBytes) {
        byte[] result = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(decryptBytes);
        } catch (Exception e) {
            throw new RuntimeException("DES解密字节错误，错误信息：", e);
        }
        return result;
    }

}
 
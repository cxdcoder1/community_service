package com.example.community.config;

import java.security.MessageDigest;

/**
 * 采用MD5加密解密
 *
 * @author tfq
 * @datetime 2011-10-13
 */
@SuppressWarnings("all")
public class MD5Util {

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");  //此句是核心
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法[可逆] 执行一次加密，执行两次解密
     */
    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        return new String(a);
    }

    // 测试主函数  
    public static void main(String args[]) {
        String s = new String("123456");
//        System.out.println("不可逆:"+ string2MD5(s));
        System.out.println("加密的:" + convertMD5(s));
        System.out.println("解密的:" + convertMD5(convertMD5(s)));
    }
}  
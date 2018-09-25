package com.wzh.demo.utils;

import java.security.MessageDigest;

public class MD5Utils {
    /***
     * MD5加码 生成32位md5码
     * @throws Exception
     */
    public static String convertMD5(String desStr) throws Exception{
        //初始化MD5哈希序列字符串
        MessageDigest md5 = null;
        try{
            //令MD5哈希序列为单例模式，可以直接调用
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        //将获取的字符串转化为字符数组
        char[] charArray = desStr.toCharArray();
        //初始化比特数组
        byte[] byteArray = new byte[charArray.length];
        //循环读取将字符数组转化成比特数组
        for (int i = 0; i < charArray.length; i++) {
            byteArray[ i ] = (byte) charArray[ i ];
        }
        //对比特数组执行MD5算法
        byte[] md5Bytes = md5.digest(byteArray);
        //初始化存取MD5哈希串的字符串流
        StringBuffer hexValue = new StringBuffer();
        //依次赋值并补位至32位
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append( "0" );
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}

package com.wzh.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    //获取系统当前时间并格式输出
    public static String getTime(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    //获取系统当前毫秒数
    public static String getSystemTime(){
        return String.valueOf(new Date().getTime());
    }

    //将数字转为固定长度字符串
    public static String numberToString(long id,int length){
        String strId = String.valueOf(id);
        int num = length - strId.length();
        StringBuffer stringBuffer = new StringBuffer();
        while(num >0 ){
            stringBuffer.append("0");
            num --;
        }
        stringBuffer.append(strId);
        return stringBuffer.toString();
    }

    //生成流水号
    public static String getFlowNumber(long in,long out){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer
                .append(CommonUtils.getTime())
                .append(CommonUtils.numberToString(in,4))
                .append(CommonUtils.numberToString(out,4))
                .append(CommonUtils.getSystemTime()).toString();
    }
}

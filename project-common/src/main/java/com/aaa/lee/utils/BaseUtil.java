package com.aaa.lee.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author gh
 * @date 2019/12/14 14:58
 */
@Slf4j
public class BaseUtil {
    //判断是否为空
    public static boolean checkIsNotNull(Object str){
        if(str!=null&&str!=""&&!str.equals("")){
            return true;
        }
        return false;
    }

    //将对象转换成字符串
    public static String transToString(Object obj){
        if(obj!=null){
            return obj.toString();
        }
        return "";
    }

    //将对象转换成数字
    public static Integer transToInt(Object obj){
        if(obj!=null&&obj!=""){
            return Integer.parseInt(obj.toString());
        }
        return null;
    }

    //获取当前时间yyyy-MM-dd
    public static Date getNowDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//设置格式
        Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            log.error(e.getMessage() + "获取当前时间出现异常");
            e.printStackTrace();
        }
        return time;
    }

    //获取当前时间yyyy-MM-dd HH:mm:ss
    public static Date getNowDateTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置格式
        Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            log.error(e.getMessage() + "获取当前时间出现异常");
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static Date getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time=null;
        try {
            time= sdf.parse(sdf.format(today));
        } catch (ParseException e) {
            log.error(e.getMessage() + "获取几天后的时间出现异常");
            e.printStackTrace();
        }
        return time;
    }


    /** 
     * 日期转换成字符串 
     * @param date 
     * @return str 
     */
    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期 
     * @param str 
     * @return date 
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
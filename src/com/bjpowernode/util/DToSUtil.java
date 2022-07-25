package com.bjpowernode.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DToSUtil {
    private static SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    public static String dToStr(Date date){
        String format = s.format(date);
        return format;
    }
    public static Date strToD(String str){
        Date pa = null;
        try {
            pa = s.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pa;
    }
}

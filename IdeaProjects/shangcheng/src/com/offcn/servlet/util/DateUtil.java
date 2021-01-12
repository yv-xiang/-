package com.offcn.servlet.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateUtil {

    public static Date stringToDate(String string){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

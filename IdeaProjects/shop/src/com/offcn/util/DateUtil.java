package com.offcn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 金喆
 */

public class DateUtil {

    public static Date strToDate(String str)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null ;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date ;
    }
}

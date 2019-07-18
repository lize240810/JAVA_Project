package com.lize.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    public static Date turnDate(String timer){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(timer);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
}

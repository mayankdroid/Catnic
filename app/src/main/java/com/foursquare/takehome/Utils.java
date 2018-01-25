package com.foursquare.takehome;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mayankgupta on 1/24/18.
 */

public class Utils {

    public static String getTime(long milliseconds){
        Date date = new Date(milliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");
        return simpleDateFormat.format(date);
    }
}

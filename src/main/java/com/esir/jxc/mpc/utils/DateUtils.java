package com.esir.jxc.mpc.utils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getDate() {
        LocalDateTime now = LocalDateTime.now();
        Calendar cal = Calendar.getInstance();
        cal.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth() - 1);
        return cal.getTime();
    }

}

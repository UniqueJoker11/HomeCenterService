package colin.app.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by joker on 14-9-13.
 */
public class DateUtils {
    /**
     * 获取当前日期
     * 格式为：yyyy－mm－dd
     */
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(calendar.getTime());
    }

    /**
     * 获取当前的日期
     * 格式为：yyyy-mm-dd
     */

    public static String getCurrentDateOfDay() {
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }
    /**
     * 获取当前的日期信息
     * 格式为：yyyymmddhhmmss
     */

    public static String getCurrentDateInfo() {
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        StringBuilder randomDate=new StringBuilder(format.format(calendar.getTime()));
        randomDate.append(Math.round(Math.random()*1000));
        return randomDate.toString();
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getCurrentDate());
        System.out.println(DateUtils.getCurrentDateOfDay());
        System.out.println(DateUtils.getCurrentDateInfo());
    }
}


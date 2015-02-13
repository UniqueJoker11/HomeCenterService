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
     * */
    public static String getCurrentDate(){
        Calendar calendar=Calendar.getInstance();
        DateFormat format=new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        return format.format(calendar.getTime());
    }
    public static void  main(String[] args){
        System.out.println(DateUtils.getCurrentDate());
    }
}


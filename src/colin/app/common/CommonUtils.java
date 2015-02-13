package colin.app.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joker on 14-9-13.
 */
public class CommonUtils {
    /**
     * 判断字符串是否是空的
     * */
    public static boolean handleEmptyStr(Object obj){
        return obj!=null&&!obj.toString().trim().equals("");
    }
    /**
     * 初始化参数类
     * */
   public static Map<String,Object> initParamsMap(){
       return new HashMap<String, Object>();
   }
  }

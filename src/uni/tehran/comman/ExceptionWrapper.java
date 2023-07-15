package uni.tehran.comman;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionWrapper {

    public static Map<String , String> getError(Exception e){
        e.printStackTrace();
        Map<String,String> map=new HashMap<>();
        if (e instanceof SQLException) {
            map.put("error", "101");
            map.put("message", "database error");
            return map;
        } else if (e instanceof NumberFormatException) {
            map.put("error", "102");
            map.put("message", "format error");
            return map;
        } else if (e instanceof NullPointerException) {
            map.put("error", "103");
            map.put("message", "initialize error");
            return map;
        } else {
            map.put("error", "200");
            map.put("message", "connect 2 support");
            return map;
        }
    }
}

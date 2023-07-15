package uni.tehran.comman;

import org.codehaus.jackson.map.ObjectMapper;

public class JSONConvertor {
    public JSONConvertor() {
    }

    public static String convert(Object o) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper() ;
        return objectMapper.writeValueAsString(o);
    }
}

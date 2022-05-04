package volunteer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JacksonUtils {
    ObjectMapper objectMapper = new ObjectMapper();


    // 将对象转成字符串
    public  String objectToString(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    // 将Bean转成Map
    public  Map beanToMap(Object obj) throws Exception {
        return objectMapper.readValue(objectToString(obj), Map.class);
    }
}

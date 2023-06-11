package club.emperor.jackson;

import club.emperor.jackson.entity.ObjectJsonAll;
import club.emperor.jackson.entity.ObjectJsonNoNull;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * JacksonTest
 *
 * @author: EmperorWS
 * @date: 2023/5/30 21:51
 * @description: JacksonTest: JacksonTest
 */
@DisplayName("Jackson相关测试")
public class JacksonTest {

    @DisplayName("serializer配置测试")
    @Test
    public void jacksonNoAllTest() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectJsonAll objectJsonAll = new ObjectJsonAll();
            String jsonString = objectMapper.writeValueAsString(objectJsonAll);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("objectMapper配置设置")
    @Test
    public void jacksonNoNullTest() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // 字段保留，将null值转为""
            objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeString("");
                }
            });
            ObjectJsonNoNull objectJsonNoNull = new ObjectJsonNoNull();
            String jsonString = objectMapper.writeValueAsString(objectJsonNoNull);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

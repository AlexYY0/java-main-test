package club.emperor.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 自定义Json序列化器
 *
 * @author: EmperorWS
 * @date: 2023/5/29 1:28
 * @description: CustomValueSerializer: 自定义Json序列化器
 */
public class CustomValueSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(value.toString());
    }
}

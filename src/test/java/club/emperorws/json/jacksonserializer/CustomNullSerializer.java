package club.emperorws.json.jacksonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 属性null时的自定义Json序列化器
 *
 * @author: EmperorWS
 * @date: 2023/5/29 1:36
 * @description: CustomNullSerializer: 属性null时的自定义Json序列化器
 */
public class CustomNullSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("");
    }
}

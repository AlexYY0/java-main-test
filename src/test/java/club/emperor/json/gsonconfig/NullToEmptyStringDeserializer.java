package club.emperor.json.gsonconfig;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * 自定义的JsonDeserializer，将null转换为空字符串
 *
 * @author: EmperorWS
 * @date: 2023/7/7 0:44
 * @description: NullToEmptyStringDeserializer: 自定义的JsonDeserializer，将null转换为空字符串
 */
public class NullToEmptyStringDeserializer implements JsonDeserializer<JsonElement> {
    @Override
    public JsonElement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonNull()) {
            // 将null值转换为空字符串
            return new JsonPrimitive("");
        } else {
            return json;
        }
    }
}

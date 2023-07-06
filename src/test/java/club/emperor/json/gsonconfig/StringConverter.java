package club.emperor.json.gsonconfig;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Gson序列化与反序列的适配器（序列化时null转空字符串）
 *
 * @author: EmperorWS
 * @date: 2023/7/7 0:18
 * @description: StringConverter: Gson序列化与反序列的适配器（序列化时null转空字符串）
 */
public class StringConverter implements JsonSerializer<String>, JsonDeserializer<String> {
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src.toString());
        }
    }

    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.getAsJsonPrimitive().getAsString();
    }
}

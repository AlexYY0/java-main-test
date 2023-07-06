package club.emperor.json.gsonconfig;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * 自定义Strig适配器
 *
 * @author: EmperorWS
 * @date: 2023/7/7 0:27
 * @description: StringNullAdapter: 自定义Strig适配器
 */
public class StringNullAdapter extends TypeAdapter<String> {
    @Override
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return "";
        }
        return reader.nextString();
    }

    @Override
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) {
            writer.nullValue();
            // 在这里处理null改为空字符串
            //writer.value("");
            return;
        }
        writer.value(value);
    }
}

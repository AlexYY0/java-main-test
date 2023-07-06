package club.emperor.json.parse;

import club.emperor.json.gsonconfig.NullToEmptyStringDeserializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * json解析测试类
 *
 * @author: EmperorWS
 * @date: 2023/7/6 23:48
 * @description: JsonParse: json解析测试类
 */
@DisplayName("json解析相关测试类")
public class JsonParseTest {

    private String jsonStr = "{\"num\": 123456789012345678901234567890.123456789012345678901234567890,\"numStr\": \"123456789012345678901234567890.123456789012345678901234567890\",\"numBigDecimal\": 10E10,\"numBigDecimalStr\": \"10E10\",\"nullObj\": null}";

    @DisplayName("net.sf.json解析测试")
    @Test
    public void netSfJsonTest() {
        //net.sf.json
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        System.out.println("jsonObject.getString(\"num\"):" + jsonObject.getString("num"));
        System.out.println("new BigDecimal(jsonObject.getString(\"num\")).toPlainString():" + new BigDecimal(jsonObject.getString("num")).toPlainString());
        System.out.println("jsonObject.getString(\"numStr\")" + jsonObject.getString("numStr"));
        System.out.println("jsonObject.getString(\"numBigDecimal\")" + jsonObject.getString("numBigDecimal"));
        System.out.println("new BigDecimal(jsonObject.getString(\"numBigDecimal\")).toPlainString()" + new BigDecimal(jsonObject.getString("numBigDecimal")).toPlainString());
        System.out.println("jsonObject.getString(\"numBigDecimalStr\")" + jsonObject.getString("numBigDecimalStr"));
        System.out.println("new BigDecimal(jsonObject.getString(\"numBigDecimalStr\")).toPlainString()" + new BigDecimal(jsonObject.getString("numBigDecimalStr")).toPlainString());
        System.out.println("----------------------------------------------------------------");
    }

    @DisplayName("jackson解析测试")
    @Test
    public void jacksonParseTest() {
        //jackson
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            System.out.println("rootNode.get(\"num\").asText()" + rootNode.get("num").asText());
            System.out.println("new BigDecimal(rootNode.get(\"num\").asText()).toPlainString()" + new BigDecimal(rootNode.get("num").asText()).toPlainString());
            System.out.println("rootNode.get(\"numBigDecimal\").asDouble()" + rootNode.get("numBigDecimal").asDouble());
            System.out.println("rootNode.get(\"numBigDecimal\").asText()" + rootNode.get("numBigDecimal").asText());
            System.out.println("new BigDecimal(rootNode.get(\"numBigDecimal\").asText()).toPlainString()" + new BigDecimal(rootNode.get("numBigDecimal").asText()).toPlainString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("gson旧版本解析测试")
    @Test
    public void gsonOldVersionTest() {
        //gson旧版本
        JsonParser gsonParser = new JsonParser();
        JsonObject gsonJsonObjectOld = gsonParser.parse(jsonStr).getAsJsonObject();
        System.out.println("gsonJsonObjectOld.get(\"num\").getAsString()" + gsonJsonObjectOld.get("num").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectOld.get(\"num\").getAsString()).toPlainString():" + new BigDecimal(gsonJsonObjectOld.get("num").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectOld.get(\"numStr\").getAsString()" + gsonJsonObjectOld.get("numStr").getAsString());
        System.out.println("gsonJsonObjectOld.get(\"numBigDecimal\").getAsString()" + gsonJsonObjectOld.get("numBigDecimal").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectOld.get(\"numBigDecimal\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectOld.get("numBigDecimal").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectOld.get(\"numBigDecimalStr\").getAsString()" + gsonJsonObjectOld.get("numBigDecimalStr").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectOld.get(\"numBigDecimalStr\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectOld.get("numBigDecimalStr").getAsString()).toPlainString());
        System.out.println("----------------------------------------------------------------");
    }

    @DisplayName("gson新版本解析测试")
    @Test
    public void gsonNewVersionTest() {
        //gson新版本
        Gson gson = new Gson();
        JsonObject gsonJsonObjectNew = gson.fromJson(jsonStr, JsonElement.class).getAsJsonObject();
        System.out.println("gsonJsonObjectNew.get(\"num\").getAsString()" + gsonJsonObjectNew.get("num").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectNew.get(\"num\").getAsString()).toPlainString():" + new BigDecimal(gsonJsonObjectNew.get("num").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectNew.get(\"numStr\").getAsString()" + gsonJsonObjectNew.get("numStr").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimal\").getAsString()" + gsonJsonObjectNew.get("numBigDecimal").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimal\").getAsBigDecimal()" + gsonJsonObjectNew.get("numBigDecimal").getAsBigDecimal());
        System.out.println("new BigDecimal(gsonJsonObjectNew.get(\"numBigDecimal\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectNew.get("numBigDecimal").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsString()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsBigDecimal()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsBigDecimal());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsBigDecimal().toPlainString()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsBigDecimal().toPlainString());
        System.out.println("new BigDecimal(gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectNew.get("numBigDecimalStr").getAsString()).toPlainString());
        System.out.println("----------------------------------------------------------------");
    }

    @DisplayName("gson解析null测试")
    @Test
    public void gsonParseNullTest() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(JsonElement.class, new NullToEmptyStringDeserializer())
                .create();
        JsonObject gsonJsonObjectNew = gson.fromJson(jsonStr, JsonElement.class).getAsJsonObject();
        JsonElement nullObj = gsonJsonObjectNew.get("nullObj");
        System.out.println("nullObj.isJsonNull() :" + nullObj.isJsonNull());
        String nullObjStr = nullObj.getAsString();
        System.out.println("nullObj" + nullObj);
    }
}

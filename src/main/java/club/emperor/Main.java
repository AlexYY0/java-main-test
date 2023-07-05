package club.emperor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 主程序
 *
 * @author: EmperorWS
 * @date: 2023/5/27 19:58
 * @description: Main: 主程序
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String jsonStr = "{\"num\": 123456789012345678901234567890,\"numStr\": \"123456789012345678901234567890\",\"numBigDecimal\": 10E10,\"numBigDecimalStr\": \"10E10\"}";

        //net.sf.json
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        System.out.println("jsonObject.getString(\"num\"):" + jsonObject.getString("num"));
        System.out.println("jsonObject.getString(\"numStr\")" + jsonObject.getString("numStr"));
        System.out.println("jsonObject.getString(\"numBigDecimal\")" + jsonObject.getString("numBigDecimal"));
        System.out.println("new BigDecimal(jsonObject.getString(\"numBigDecimal\")).toPlainString()" + new BigDecimal(jsonObject.getString("numBigDecimal")).toPlainString());
        System.out.println("jsonObject.getString(\"numBigDecimalStr\")" + jsonObject.getString("numBigDecimalStr"));
        System.out.println("new BigDecimal(jsonObject.getString(\"numBigDecimalStr\")).toPlainString()" + new BigDecimal(jsonObject.getString("numBigDecimalStr")).toPlainString());
        System.out.println("----------------------------------------------------------------");

        //gson旧版本
        JsonParser gsonParser = new JsonParser();
        JsonObject gsonJsonObjectOld = gsonParser.parse(jsonStr).getAsJsonObject();
        System.out.println("gsonJsonObjectOld.get(\"num\").getAsString()" + gsonJsonObjectOld.get("num").getAsString());
        System.out.println("gsonJsonObjectOld.get(\"numStr\").getAsString()" + gsonJsonObjectOld.get("numStr").getAsString());
        System.out.println("gsonJsonObjectOld.get(\"numBigDecimal\").getAsString()" + gsonJsonObjectOld.get("numBigDecimal").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectOld.get(\"numBigDecimal\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectOld.get("numBigDecimal").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectOld.get(\"numBigDecimalStr\").getAsString()" + gsonJsonObjectOld.get("numBigDecimalStr").getAsString());
        System.out.println("new BigDecimal(gsonJsonObjectOld.get(\"numBigDecimalStr\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectOld.get("numBigDecimalStr").getAsString()).toPlainString());
        System.out.println("----------------------------------------------------------------");

        //gson新版本
        Gson gson = new Gson();
        JsonObject gsonJsonObjectNew = gson.fromJson(jsonStr, JsonElement.class).getAsJsonObject();
        System.out.println("gsonJsonObjectNew.get(\"num\").getAsString()" + gsonJsonObjectNew.get("num").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numStr\").getAsString()" + gsonJsonObjectNew.get("numStr").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimal\").getAsString()" + gsonJsonObjectNew.get("numBigDecimal").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimal\").getAsBigDecimal()" + gsonJsonObjectNew.get("numBigDecimal").getAsBigDecimal());
        System.out.println("new BigDecimal(gsonJsonObjectNew.get(\"numBigDecimal\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectNew.get("numBigDecimal").getAsString()).toPlainString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsString()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsString());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsBigDecimal()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsBigDecimal());
        System.out.println("gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsBigDecimal().toPlainString()" + gsonJsonObjectNew.get("numBigDecimalStr").getAsBigDecimal().toPlainString());
        System.out.println("new BigDecimal(gsonJsonObjectNew.get(\"numBigDecimalStr\").getAsString()).toPlainString()" + new BigDecimal(gsonJsonObjectNew.get("numBigDecimalStr").getAsString()).toPlainString());
    }
}

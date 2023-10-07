package club.emperorws.expression.aviator;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * aviator表达式引擎测试类
 *
 * @author: EmperorWS
 * @date: 2023/10/7 19:56
 * @description: ExprTest: aviator表达式引擎测试类
 */
@DisplayName("aviator表达式引擎相关测试")
public class ExprTest {

    @DisplayName("aviator的True、False判断")
    @Test
    public void expressionTrueFalseTest() {
        /*Map<String, Object> params = new HashMap<>();
        params.put("age", 65);
        Boolean exprResult = ExpressionUtils.<Boolean>executeExpression("age > 60", params);*/
        /*JSONObject params = JSONObject.fromObject("{\"age\":\"65\"}");
        Boolean exprResult = ExpressionUtils.<Boolean>executeExpression("long(age) > 60", params);*/
        JSONObject params = JSONObject.fromObject("{\"isAgeOlder\":\"True\"}");
        Boolean exprResult = Boolean.TRUE.equals(ExpressionUtils.<Boolean>executeExpression("isAgeOlder", params));
        Boolean exprResult1 = ExpressionUtils.<Boolean>executeExpression("boolean(isAgeOlder)", params);
        Boolean exprResult2 = ExpressionUtils.<Boolean>executeExpression("isAgeOlder == 'True'", params);
        System.out.println(exprResult);
        System.out.println(exprResult1);
        System.out.println(exprResult2);
    }
}

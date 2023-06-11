package club.emperor.http;

import club.emperor.config.HttpClientConfig;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OkHttp的测试类
 *
 * @author: EmperorWS
 * @date: 2023/6/11 20:13
 * @description: OkHttpTest: OkHttp的测试类
 */
@DisplayName("OkHttp的相关测试")
public class OkHttpTest {

    private static final Logger logger = LoggerFactory.getLogger(OkHttpTest.class);

    @DisplayName("OkHttp的Get测试")
    @Test
    public void testOkHttp() throws Exception {
        // 配置GET请求
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .get()
                .build();

        // 发起同步请求
        try (Response response = HttpClientConfig.client().newCall(request).execute()) {
            // 打印返回结果
            logger.info("get response code is {}", response.code());
            logger.info("get response message is {}", response.message());
            logger.info("get response headers is \n{}", response.headers());
            logger.info("get response body is {}", response.body().string());
        } catch (Exception e) {
            logger.error("get execute has an error.", e);
        }
    }
}

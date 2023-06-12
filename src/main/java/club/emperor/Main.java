package club.emperor;

import club.emperor.config.HttpClientConfig;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        // 配置GET请求
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .header("meta.proxy", "http:127.0.0.1:7890")
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

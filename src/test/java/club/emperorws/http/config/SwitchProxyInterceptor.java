package club.emperorws.http.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 代理动态选择的拦截器
 *
 * @author: EmperorWS
 * @date: 2023/6/12 22:55
 * @description: SwitchProxyInterceptor: 代理动态选择的拦截器
 */
public class SwitchProxyInterceptor implements Interceptor {

    private final static Logger logger = LoggerFactory.getLogger(SwitchProxyInterceptor.class);

    @NotNull
    public Response intercept(@NotNull Chain chain) throws IOException {
        if (chain.request().header("meta.proxy") != null) {
            String proxyHeader = chain.request().header("meta.proxy");
            logger.debug("detect proxy header : {}", proxyHeader);
            SwitchProxySelector.proxyThreadLocal.set(SwitchProxySelector.getProxy(proxyHeader));
            Request newRequest = chain.request().newBuilder().removeHeader("meta.proxy").build();
            return chain.proceed(newRequest);
        }
        return chain.proceed(chain.request());
    }

}

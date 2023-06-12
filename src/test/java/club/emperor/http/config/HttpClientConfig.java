package club.emperor.http.config;

import club.emperor.config.EasyX509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * Http客户段连接相关配置
 *
 * @author: EmperorWS
 * @date: 2023/6/11 19:08
 * @description: HttpClientConfig: Http客户段连接相关配置
 */
public class HttpClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientConfig.class);

    private Integer connectTimeout = 20;

    private Integer readTimeout = 60;

    private Integer writeTimeout = 60;

    private Integer maxIdleConnections = 5;

    private Long keepAliveDuration = 6L;

    private OkHttpClient httpClient;

    private static final HttpClientConfig INSTANCE = new HttpClientConfig();

    static {
        try {
            INSTANCE.init();
        } catch (IOException | NoSuchAlgorithmException | KeyStoreException e) {
            logger.error("HttpClientConfig init error.", e);
        }
    }

    public static HttpClientConfig instance() {
        return INSTANCE;
    }

    public static OkHttpClient client() {
        return INSTANCE.httpClient;
    }

    public void init() throws IOException, NoSuchAlgorithmException, KeyStoreException {
        this.httpClient = createOkHttpClient();
    }

    public OkHttpClient createOkHttpClient() throws IOException, NoSuchAlgorithmException, KeyStoreException {
        return new OkHttpClient().newBuilder()
                .connectionPool(pool())
                //设置连接超时
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                //忽略本地校验url正确性(验证服务器的证书域名。在https握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接)
                .hostnameVerifier((hostname, session) -> true)
                // 设置https配置，此处忽略了所有证书
                .sslSocketFactory(createEasySSLContext().getSocketFactory(), new EasyX509TrustManager(null))
                // 设置代理（固定）
                //.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
                //设置代理的动态选择
                .addInterceptor(new SwitchProxyInterceptor())
                .proxySelector(new SwitchProxySelector())
                //拦截器
                //.addInterceptor()
                .build();
    }

    /**
     * 设置连接池
     *
     * @return 连接池
     */
    public ConnectionPool pool() {
        // 定义连接池，最多有maxIdleConnections个空闲连接，每个空闲连接最多保持keepAliveDuration秒
        return new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MINUTES);
    }

    /**
     * 设置HTTPS的SSL证书信息
     *
     * @return HTTPS的SSL证书信息
     * @throws IOException 异常
     */
    private static SSLContext createEasySSLContext() throws IOException {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            return context;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}

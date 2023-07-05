package club.emperor.http.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 代理动态选择的选择器
 *
 * @author: EmperorWS
 * @date: 2023/6/12 22:57
 * @description: SwitchProxySelector: 代理动态选择的选择器
 */
public class SwitchProxySelector extends ProxySelector {


    private final static Logger logger = LoggerFactory.getLogger(SwitchProxySelector.class);

    /**
     * proxy 模式的判断
     */
    private static final Pattern PROXY_PATTERN = Pattern.compile("(socket|http):(.*):(.*)");

    public static ThreadLocal<Proxy> proxyThreadLocal = new ThreadLocal<>();


    /**
     * 根据 URL 返回代理列表
     */
    public List<Proxy> select(URI uri) {
        Proxy proxy = SwitchProxySelector.proxyThreadLocal.get();
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        logger.info("{} use proxy {}:{}", uri.toString(), proxy.type().name(), proxy.address());
        SwitchProxySelector.proxyThreadLocal.remove();
        return Collections.singletonList(proxy);
    }


    /**
     * 代理失败时，可以删除代理等操作
     */
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    }

    /**
     * 工厂方法 获取Proxy
     *
     * @param proxyString meta.proxy 中的 proxy 字符串
     * @return Proxy
     */
    static Proxy getProxy(String proxyString) {
        if (proxyString == null || "".equals(proxyString)) {
            return Proxy.NO_PROXY;
        }
        Matcher matcher = PROXY_PATTERN.matcher(proxyString);
        if (matcher.matches()) {
            switch (matcher.group(1)) {
                case "socket":
                    return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(matcher.group(2), Integer.parseInt(matcher.group(3))));
                case "http":
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(matcher.group(2), Integer.parseInt(matcher.group(3))));
                default:
                    return Proxy.NO_PROXY;
            }
        }
        return Proxy.NO_PROXY;
    }
}

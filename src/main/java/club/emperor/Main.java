package club.emperor;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
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
        /*Type type = new TypeToken<Response<String>>() {
        }.getType();*/
        String userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 Edg/114.0.1823.82";
        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        ReadableUserAgent userAgent = parser.parse(userAgentString);
        logger.info("User Agent: " + userAgent);
    }
}

package club.emperorws.userAgent;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User-Agent解析
 *
 * @author: EmperorWS
 * @date: 2023/7/21 22:14
 * @description: UserAgentParse: User-Agent解析
 */
@DisplayName("User-Agent解析相关测试类")
public class UserAgentParseTest {

    private static final Logger logger = LoggerFactory.getLogger(UserAgentParseTest.class);

    @DisplayName("net.sf.uadetector解析测试")
    @Test
    public void netSfUadetectorTest() {
        String userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 Edg/114.0.1823.82";
        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        ReadableUserAgent userAgent = parser.parse(userAgentString);
        logger.info("name: {}, version:{}", userAgent.getName(), userAgent.getVersionNumber().toVersionString());
        logger.info("OperatingSystemt: {}, OperatingSystem Version:{}", userAgent.getOperatingSystem().getName(), userAgent.getOperatingSystem().getVersionNumber().toVersionString());
        logger.info("User Agent: {}", userAgent);
    }
}

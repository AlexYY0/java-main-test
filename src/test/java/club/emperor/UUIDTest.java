package club.emperor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * UUIDTest
 *
 * @author: EmperorWS
 * @date: 2023/5/30 21:44
 * @description: UUIDTest: UUIDTest
 */
@DisplayName("UUID相关测试")
public class UUIDTest {

    @DisplayName("nameUUIDFromBytes")
    @Test
    public void uuidTest() {
        try {
            String uuidStr1 = "asdsdadasdrwerwr我看见你了。";
            String uuidStr2 = "我看见你了。";
            System.out.println(UUID.nameUUIDFromBytes(uuidStr1.getBytes(StandardCharsets.UTF_8)).toString());
            System.out.println(UUID.nameUUIDFromBytes(uuidStr1.getBytes("UTF-8")).toString());
            System.out.println(UUID.nameUUIDFromBytes(uuidStr1.getBytes("GBK")).toString());
            System.out.println(UUID.nameUUIDFromBytes(uuidStr1.getBytes("GBK")).toString());
            System.out.println(UUID.nameUUIDFromBytes(uuidStr2.getBytes(StandardCharsets.UTF_8)).toString());
            System.out.println(UUID.nameUUIDFromBytes(uuidStr2.getBytes("GBK")).toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

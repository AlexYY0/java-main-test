package club.emperorws.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static club.emperorws.constants.ObjectConstants.OBJECT_MAPPER;

/**
 * Socket的具体执行线程
 *
 * @author: EmperorWS
 * @date: 2024/4/21 13:30
 * @description: SocketThread: Socket的具体执行线程
 */
public class SocketThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(SocketThread.class);

    private long beginTime;

    private static String mockResult;

    static {
        try {
            mockResult = OBJECT_MAPPER.writeValueAsString(createMockResult()) + "\r\n";
        } catch (JsonProcessingException e) {
            logger.error("mockResult create has an error!", e);
        }
    }

    private Socket socket;

    public SocketThread(Socket socket) throws SocketException {
        beginTime = System.currentTimeMillis();
        this.socket = socket;
        socket.setSoTimeout(25000);
        // socket.setKeepAlive(true);
        socket.setReuseAddress(true);
    }

    @Override
    public void run() {
        long beginTime0 = System.currentTimeMillis();
        long cost0 = beginTime0 - beginTime, cost1 = 0, cost2 = 0, cost3 = 0;
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"))
        ) {
            cost1 = System.currentTimeMillis() - beginTime0;
            // logger.info("socket is KeepAlive? {}", socket.getKeepAlive());

            long beginTime1 = System.currentTimeMillis();
            String info = null;
            while (!("bye".equals(info = br.readLine()))) {
                // logger.info("我是服务器，客户端说：{}", info);
            }
            // logger.info("我是服务器，客户端说：{}", info = br.readLine());
            // socket.shutdownInput();
            cost2 = System.currentTimeMillis() - beginTime1;

            // String resultStr = OBJECT_MAPPER.writeValueAsString(createMockResult()) + "\r\n";

            long beginTime2 = System.currentTimeMillis();
            bw.write(mockResult);
            bw.flush();
            cost3 = System.currentTimeMillis() - beginTime2;
            // logger.info("请求返回结束！");
        } catch (Exception e) {
            logger.error("SocketThread Run has an error!", e);
        } finally {
            long beginTime3 = System.currentTimeMillis();
            // 关闭资源
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                logger.error("SocketThread Run close socket has an error!", e);
            }
            long endTime = System.currentTimeMillis();
            long cost = endTime - beginTime;
            if (cost > 20) {
                logger.info("Cost: {}, Cost Wait: {}, Cost Stream: {}, Cost Read: {}, Cost Write: {}, Cost Close: {}", cost, cost0, cost1, cost2, cost3, endTime - beginTime3);
            }
        }
    }

    private static List<Map<String, Object>> createMockResult() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> obj1 = new HashMap<>();
        obj1.put("name", "张三");
        obj1.put("sex", "男");
        obj1.put("email", "123123@gmail.com");
        obj1.put("address", "地球亚洲中华人民共和国福建省福州市高新区啦啦啦啦啦街道废物小区123213号");
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        result.add(obj1);
        return result;
    }
}

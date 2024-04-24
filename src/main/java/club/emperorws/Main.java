package club.emperorws;

import club.emperorws.socket.SocketThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 主程序
 *
 * @author: EmperorWS
 * @date: 2023/5/27 19:58
 * @description: Main: 主程序
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static ThreadPoolExecutor socketWorkThreadPool = new ThreadPoolExecutor(
            24, 24, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            // 创建服务端socket
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(3005));

            // 创建客户端socket
            Socket socket = null;

            // 循环监听等待客户端的连接
            while (true) {
                try {
                    // 监听客户端
                    socket = serverSocket.accept();

                    SocketThread thread = new SocketThread(socket);
                    socketWorkThreadPool.execute(thread);

                    // InetAddress address = socket.getInetAddress();
                    // logger.info("当前客户端的IP：{}，Port：{}, HostName: {}", address.getHostAddress(), socket.getPort(), address.getHostName());
                } catch (IOException e) {
                    logger.error("ServerSocket accept has an error!", e);
                }
            }
        } catch (Exception e) {
            logger.error("ServerSocket has an error!", e);
        }
    }
}

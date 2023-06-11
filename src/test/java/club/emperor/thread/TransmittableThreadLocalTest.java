package club.emperor.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TransmittableThreadLocal测试类
 *
 * @author: EmperorWS
 * @date: 2023/6/11 18:44
 * @description: TransmittableThreadLocalTest: TransmittableThreadLocal测试类
 */
@DisplayName("TransmittableThreadLocal相关测试")
public class TransmittableThreadLocalTest {

    @DisplayName("TransmittableThreadLocal-TtlRunnable测试")
    @Test
    public void transmittableThreadLocalTest() {
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

        // =====================================================

        // 在父线程中设置
        context.set("value-set-in-parent");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> System.out.println(context.get());
        // 额外的处理，生成修饰了的对象ttlCallable
        //Callable ttlCallable = TtlCallable.get(call);
        Runnable ttlRunnable = TtlRunnable.get(runnable);
        executorService.submit(ttlRunnable);

        // =====================================================

        // Call中可以读取，值是"value-set-in-parent"
        String value = context.get();
        System.out.println(value);
    }
}

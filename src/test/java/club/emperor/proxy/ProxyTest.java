package club.emperor.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理相关测试
 *
 * @author: EmperorWS
 * @date: 2023/5/17 23:57
 * @description: ProxyTest:
 */
@DisplayName("动态代理相关测试")
public class ProxyTest {

    @DisplayName("两种动态代理方式测试")
    @Test
    public void proxyTest() {

        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行上交班费的方法
        //stuProxy.giveMoney();
        stuProxy.personDefault();
    }
}

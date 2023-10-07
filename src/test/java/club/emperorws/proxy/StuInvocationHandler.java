package club.emperorws.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * todo
 *
 * @author: EmperorWS
 * @date: 2023/5/17 23:55
 * @description: StuInvocationHandler:
 */
public class StuInvocationHandler<T> implements InvocationHandler {

    private static final int ALLOWED_MODES = MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC;

    //invocationHandler持有的被代理对象
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*String fakeTarget = "fakeTarget";
        System.out.println("代理执行" +method.getName() + "方法");
        //代理过程中插入监测方法,计算该方法耗时
        System.out.println("代理执行" +method.getName() + "方法---start");
        Object result = method.invoke(target, args);
        System.out.println("代理执行" +method.getName() + "方法---finish");
        return result;*/

        /*System.out.println("MethodHandle代理执行" +method.getName() + "方法");
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findVirtual(Person.class, "giveMoney", MethodType.methodType(void.class,new Class<?>[]{}));
        return methodHandle.invoke(proxy);*/

        /*System.out.println("MethodHandle代理执行" +method.getName() + "方法");
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.unreflectSpecial(method, Person.class);
        return methodHandle.invoke(proxy);*/

        /*System.out.println("MethodHandle代理执行" + method.getName() + "方法，来自" + method.getDeclaringClass().getName());
        Constructor<MethodHandles.Lookup> lookupConstructor =  MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
        lookupConstructor.setAccessible(true);
        MethodHandles.Lookup lookup = lookupConstructor.newInstance(Person.class, ALLOWED_MODES);
        MethodHandle methodHandle = lookup.findVirtual(Person.class, "giveMoney", MethodType.methodType(void.class,new Class<?>[]{}));
        return methodHandle.invoke(proxy);*/

        if (method.getName().equals("personDefault")){
            System.out.println("MethodHandle代理执行" + method.getName() + "方法，来自" + method.getDeclaringClass().getName());
            Constructor<MethodHandles.Lookup> lookupConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
            lookupConstructor.setAccessible(true);
            MethodHandles.Lookup lookup = lookupConstructor.newInstance(Person.class, ALLOWED_MODES);
            MethodHandle methodHandle = lookup.unreflectSpecial(method, Person.class);
            //return methodHandle.invoke(target);
            return methodHandle.invoke(proxy);
        }
        if (method.getName().equals("giveMoney")){
            System.out.println("invoke代理执行" + method.getName() + "方法，来自" + method.getDeclaringClass().getName());
            Object result = method.invoke(target, args);
            return result;
        }
        return null;
    }
}

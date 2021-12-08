package com.vectorx.pattern.t11_proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class TeacherFactory {
    /**
     * 目标对象
     */
    private Object target;

    public TeacherFactory(Object target) {
        this.target = target;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            //1. ClassLoader loader：指定当前目标对象使用的类加载器，获取加载器的方法固定
            //2. Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认类型
            //3. InvocationHandler h：事情处理，执行目标对象的方法时触发事情处理器方法，把当前执行的目标对象方法作为参数传入
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理授课开始...");
                Object returnVal = method.invoke(target, args);
                System.out.println("JDK代理授课结束...");
                return returnVal;
            }
        });
    }
}

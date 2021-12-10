package com.vectorx.pattern.t11_proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理工厂类
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造函数
     *
     * @param target
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // 1、创建工具类
        Enhancer enhancer = new Enhancer();
        // 2、设置父类
        enhancer.setSuperclass(target.getClass());
        // 3、设置回调函数
        enhancer.setCallback(this);
        // 4、创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始...");
        Object retVal = method.invoke(target, args);
        System.out.println("cglib代理结束...");
        return retVal;
    }
}

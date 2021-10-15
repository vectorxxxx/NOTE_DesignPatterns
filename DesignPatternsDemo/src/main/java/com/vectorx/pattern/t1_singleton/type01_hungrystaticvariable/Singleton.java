package com.vectorx.pattern.t1_singleton.type01_hungrystaticvariable;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部创建对象
    private static final Singleton instance = new Singleton();

    // 3、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}

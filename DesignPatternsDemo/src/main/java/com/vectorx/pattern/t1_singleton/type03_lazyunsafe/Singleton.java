package com.vectorx.pattern.t1_singleton.type03_lazyunsafe;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、向外暴露一个静态的公共方法，当使用到该方法时，才去创建instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
package com.vectorx.pattern.t1_singleton.type02_hungrystaticblock;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、在静态代码块中创建对象
    static {
        instance = new Singleton();
    }

    // 4、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
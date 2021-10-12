package com.vectorx.singleton.type05_lazysafe_synchronizationblock;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象
    private static Singleton instance;

    // 3、向外暴露一个静态的公共方法，加入同步处理的代码块
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
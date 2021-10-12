package com.vectorx.singleton.type06_doublecheck;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、类的内部声明对象，同时用volatile关键字修饰
    private static volatile Singleton instance;

    // 3、向外暴露一个静态的公共方法，加入同步处理的代码块，并进行双重判断，解决线程安全问题
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
package com.vectorx.pattern.t1_singleton.type07_staticinnerclass;

public class Singleton {
    // 1、构造器私有化
    private Singleton() {
    }

    // 2、定义一个静态内部类，内部定义当前类的静态属性
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3、向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
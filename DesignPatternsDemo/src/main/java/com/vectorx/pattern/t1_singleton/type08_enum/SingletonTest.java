package com.vectorx.pattern.t1_singleton.type08_enum;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1 == instance2); // true
        System.out.println(instance1.hashCode() + ", " + instance2.hashCode()); // 1735600054, 1735600054
        instance1.sayHello();
        instance2.sayHello();
    }
}

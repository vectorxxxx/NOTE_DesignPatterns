package com.vectorx.pattern.t10_flyweight;

/**
 * 具体的享元角色
 */
public class ConcreteWebsite extends Website {

    private Type type;

    public ConcreteWebsite(Type type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站正在使用中：类型为" + type.name() + "，使用者为" + user.getName());
    }
}

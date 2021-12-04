package com.vectorx.pattern.t10_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 */
public class WebsiteFactory {
    private static Map<Type, Website> pool = new HashMap<>();

    public static Website getWebsiteCategory(Type type) {
        if (pool.get(type) == null) {
            pool.put(type, new ConcreteWebsite(type));
        }
        return pool.get(type);
    }

    public static Integer getSize() {
        return pool.size();
    }
}

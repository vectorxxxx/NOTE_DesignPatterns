package com.vectorx.pattern.t16_observer.observer;

/**
 * 观察者接口
 */
public interface Observer {
    void update(Float temperature, Float pressure, Float humidity);
}

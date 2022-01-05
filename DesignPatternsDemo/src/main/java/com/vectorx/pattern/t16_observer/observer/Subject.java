package com.vectorx.pattern.t16_observer.observer;

/**
 * 主体对象接口
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

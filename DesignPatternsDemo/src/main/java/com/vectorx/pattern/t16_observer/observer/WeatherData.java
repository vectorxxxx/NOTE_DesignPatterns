package com.vectorx.pattern.t16_observer.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主体对象实现
 */
public class WeatherData implements Subject {
    private Float temperature;
    private Float pressure;
    private Float humidity;
    private List<Observer> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getHumidity() {
        return humidity;
    }

    /**
     * 推送天气数据到网站
     */
    public void dataChange() {
        notifyObservers();
    }

    /**
     * 当天气数据发生变化时进行更新
     *
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(Float temperature, Float pressure, Float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (o != null && observerList.contains(o)) {
            observerList.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, pressure, humidity);
        }
    }
}

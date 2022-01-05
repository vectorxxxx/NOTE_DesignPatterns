package com.vectorx.pattern.t16_observer.tradition;

/**
 * 核心类
 * 1、包含最新的天气信息情况
 * 2、含有 CurrentConditions 对象
 * 3、当数据更新时，主动调用 CurrentConditions 的 update() 方法
 */
public class WeatherData {
    private Float temperature;
    private Float pressure;
    private Float humidity;
    private CurrentConditions conditions;

    /**
     * 传入 CurrentConditions 对象
     *
     * @param conditions
     */
    public WeatherData(CurrentConditions conditions) {
        this.conditions = conditions;
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
        conditions.update(getTemperature(), getPressure(), getHumidity());
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
}

package com.vectorx.pattern.t16_observer.observer;

/**
 * 新增的三方观察者对象——百度网
 */
public class BaiDuWebSite implements Observer {
    private Float temperature;
    private Float pressure;
    private Float humidity;

    /**
     * 更新天气情况，通过推送的方式，由 WeatherData 调用
     *
     * @param temperature
     * @param pressure
     * @param humidity
     */
    @Override
    public void update(Float temperature, Float pressure, Float humidity) {
        // 更新最新天气数据
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 展示最新天气数据
        display();
    }

    /**
     * 公告板展示天气情况
     */
    public void display() {
        System.out.println("============百度网-最新天气============");
        System.out.println("*** 百度网-当前温度：" + this.temperature + " ℃ ***");
        System.out.println("*** 百度网-当前气压：" + this.pressure + " kPa ***");
        System.out.println("*** 百度网-当前湿度：" + this.humidity + " %RH ***");
    }
}

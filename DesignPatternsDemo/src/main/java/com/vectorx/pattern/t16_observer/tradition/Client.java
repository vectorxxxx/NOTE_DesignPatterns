package com.vectorx.pattern.t16_observer.tradition;

public class Client {
    public static void main(String[] args) {
        // 创建气象网站对象
        CurrentConditions currentConditions = new CurrentConditions();
        // 创建气象数据对象，并传入气象网站对象
        WeatherData weatherData = new WeatherData(currentConditions);
        // 天气发生变化时，更新最新的气象数据
        weatherData.setData(10f, 150f, 40f);
        weatherData.setData(15f, 130f, 60f);
        weatherData.setData(13f, 160f, 20f);
    }
}

package com.vectorx.pattern.t16_observer.observer;

public class Client {
    public static void main(String[] args) {
        // 创建气象网站对象
        CurrentConditions currentConditions = new CurrentConditions();
        // 创建气象数据对象
        WeatherData weatherData = new WeatherData();
        // 注册气象网站对象
        weatherData.registerObserver(currentConditions);
        // 天气发生变化时，更新最新的气象数据
        weatherData.setData(10f, 150f, 40f);
        //============最新天气============
        //*** 当前温度：10.0 ℃ ***
        //*** 当前气压：150.0 kPa ***
        //*** 当前湿度：40.0 %RH ***

        // 新增三方气象网站，只需注册即可
        weatherData.registerObserver(new SinaWebSite());
        weatherData.registerObserver(new BaiDuWebSite());
        // 天气发生变化时，更新最新的气象数据
        weatherData.setData(15f, 120f, 80f);
        //============最新天气============
        //*** 当前温度：15.0 ℃ ***
        //*** 当前气压：120.0 kPa ***
        //*** 当前湿度：80.0 %RH ***
        //============新浪网-最新天气============
        //*** 新浪网-当前温度：15.0 ℃ ***
        //*** 新浪网-当前气压：120.0 kPa ***
        //*** 新浪网-当前湿度：80.0 %RH ***
        //============百度网-最新天气============
        //*** 百度网-当前温度：15.0 ℃ ***
        //*** 百度网-当前气压：120.0 kPa ***
        //*** 百度网-当前湿度：80.0 %RH ***

        // 移除气象网站
        weatherData.removeObserver(currentConditions);
        weatherData.setData(20f, 160f, 30f);
        //============新浪网-最新天气============
        //*** 新浪网-当前温度：20.0 ℃ ***
        //*** 新浪网-当前气压：160.0 kPa ***
        //*** 新浪网-当前湿度：30.0 %RH ***
        //============百度网-最新天气============
        //*** 百度网-当前温度：20.0 ℃ ***
        //*** 百度网-当前气压：160.0 kPa ***
        //*** 百度网-当前湿度：30.0 %RH ***
    }
}

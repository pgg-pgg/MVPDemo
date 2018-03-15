package com.pgg.mvptest.model;

import com.pgg.mvptest.bean.WeatherData;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by PDD on 2017/12/22.
 */

public interface WeatherModel {

    //此接口定义获取天气信息的方法，返回一个Subscription，便于注销监听
    Subscription getWeatherData(Subscriber<WeatherData> subscriber,String format, String city);
}

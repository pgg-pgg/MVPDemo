package com.pgg.mvptest.view;

import com.pgg.mvptest.bean.WeatherData;

/**
 * Created by PDD on 2017/12/22.
 */

public interface WeatherView {

    //此接口主要用于定义显示view的一些方法
    void ShowProgress();//显示加载进度条
    void hideProgress();//隐藏加载进度条
    void loadWeather(WeatherData weatherData);//通过传递过来的天气数据，将数据展示在控件上

}

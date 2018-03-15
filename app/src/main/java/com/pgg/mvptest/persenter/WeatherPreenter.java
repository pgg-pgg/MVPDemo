package com.pgg.mvptest.persenter;

/**
 * Created by PDD on 2017/12/22.
 */

public abstract class WeatherPreenter extends BasePresenter {

    /**
     * 获取天气信息
     * @param format
     * @param city
     */
    public abstract void getWeatherData(String format, String city);
}

package com.pgg.mvptest.model;

import com.pgg.mvptest.api.WeatherApiManager;
import com.pgg.mvptest.api.WeatherApiService;
import com.pgg.mvptest.bean.WeatherData;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by PDD on 2017/12/22.
 */

public class WeatherModelImpl implements WeatherModel {

    @Override
    public Subscription getWeatherData(Subscriber<WeatherData> subscriber,String format, String city) {
        Observable<WeatherData> weatherData = WeatherApiManager.getWeatherData(format, city);
        Subscription subscribe = weatherData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
        return subscribe;
    }
}

package com.pgg.mvptest.persenter;

import android.util.Log;
import android.widget.Toast;

import com.pgg.mvptest.bean.WeatherData;
import com.pgg.mvptest.model.WeatherModel;
import com.pgg.mvptest.model.WeatherModelImpl;
import com.pgg.mvptest.view.WeatherView;

import rx.Subscriber;

/**
 * Created by PDD on 2017/12/22.
 */

public class WeatherPrenterImpl extends WeatherPreenter {
    /**
     * WeatherModel和WeatherView都是通过接口来实现，这就Java设计原则中依赖倒置原则使用
     */
    private WeatherModel mWeatherModel;
    private WeatherView mWeatherView;

    /**
     * 封装请求过程的rxjava与retrofit
     */
    Subscriber<WeatherData> subscriber=new Subscriber<WeatherData>() {
        @Override
        public void onCompleted() {
            mWeatherView.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            mWeatherView.hideProgress();
            Log.d("-------", "onFailure" + e.getMessage());
        }

        @Override
        public void onNext(WeatherData weatherData) {
            mWeatherView.loadWeather(weatherData);
            mWeatherView.hideProgress();
        }
    };

    public WeatherPrenterImpl( WeatherView mWeatherView) {
        this.mWeatherModel = new WeatherModelImpl();
        this.mWeatherView = mWeatherView;
    }
    @Override
    public void getWeatherData(String format, String city) {
        mWeatherView.ShowProgress();
        addSubscription(mWeatherModel.getWeatherData(subscriber,format,city));
    }
}

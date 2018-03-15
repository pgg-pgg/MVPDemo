package com.pgg.mvptest.api;

import com.pgg.mvptest.bean.WeatherData;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by PDD on 2017/12/22.
 * 对WeatherAPIService的使用
 */

public class WeatherApiManager {

    private static final String ENDPOINT = "http://v.juhe.cn";

    private static final Retrofit sRetrofit = new Retrofit .Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final WeatherApiService apiManager = sRetrofit.create(WeatherApiService.class);

    /**
     * 获取天气数据
     * @param city
     * @return
     */
    public static Observable<WeatherData> getWeatherData(String format, String city) {
        return apiManager.getWherData(format,city,"e9750ded30ad2caf6f3c2dee31504c6e");
    }
}

package com.pgg.mvptest.api;

import com.pgg.mvptest.bean.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by PDD on 2017/12/22.
 */

public interface WeatherApiService {

    //http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=JHcee9b557d3e6c747375d4ae68ee1d9dc
    /**
     * 此接口用于从网络获取数据的接口，使用retrofit框架
     */
    @GET("/weather/index")
    Observable<WeatherData> getWherData(@Query("format") String format,@Query("cityname") String cityname,@Query("key") String key);
}

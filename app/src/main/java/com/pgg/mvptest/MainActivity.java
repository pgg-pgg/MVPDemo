package com.pgg.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.pgg.mvptest.bean.WeatherData;
import com.pgg.mvptest.persenter.WeatherPreenter;
import com.pgg.mvptest.persenter.WeatherPrenterImpl;
import com.pgg.mvptest.view.WeatherView;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WeatherView{

    @Bind(R.id.tv_city)
    TextView tv_city;

    @Bind(R.id.tv_day)
    TextView tv_day;

    @Bind(R.id.tv_today_temp)
    TextView tv_today_temp;

    @Bind(R.id.tv_temp_icon)
    TextView tv_temp_icon;

    @Bind(R.id.tv_num_close)
    TextView tv_num_close;

    @Bind(R.id.tv_num_ganzao)
    TextView tv_num_ganzao;

    @Bind(R.id.tv_num_ziwaixian)
    TextView tv_num_ziwaixian;

    @Bind(R.id.tv_chuanyijianyi)
    TextView tv_chuanyijianyi;

    @Bind(R.id.tv_lveyouzhishu)
    TextView tv_lveyouzhishu;

    private WeatherPreenter mWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mWeatherPresenter = new WeatherPrenterImpl(this);
        mWeatherPresenter.getWeatherData("2", "西安");

    }

    @Override
    public void ShowProgress() {
        Toast.makeText(this,"正在获取数据...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadWeather(WeatherData weatherData) {
        Log.d("weatherData", "weatherData==" + weatherData.toString());
        tv_city.setText("城市："+weatherData.getResult().getToday().getCity());
        tv_day.setText("日期："+weatherData.getResult().getToday().getWeek());
        tv_today_temp.setText("今日温度："+weatherData.getResult().getToday().getTemperature());
        tv_temp_icon.setText("天气标识：" +weatherData.getResult().getToday().getWeather());
        tv_num_close.setText("穿衣指数：" + weatherData.getResult().getToday().getDressing_advice());
        tv_num_ganzao.setText("干燥指数："+weatherData.getResult().getToday().getDressing_index());
        tv_num_ziwaixian.setText("紫外线强度："+weatherData.getResult().getToday().getUv_index());
        tv_chuanyijianyi.setText("穿衣建议："+weatherData.getResult().getToday().getDressing_advice());
        tv_lveyouzhishu.setText("旅游指数："+weatherData.getResult().getToday().getTravel_index());
    }
}

package com.example.api_weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_weather.adapter.DailyForecastAdapter;
import com.example.api_weather.adapter.H12Adapter;
import com.example.api_weather.api.APIManager;
import com.example.api_weather.model.Daily;
import com.example.api_weather.model.DailyForecast;
import com.example.api_weather.model.Weather;
import com.example.api_weather.model.hourse12.HourseWeather;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnClickItem{
    TextView tvCategory,tvEndDate;
    ImageView ivBk;
    List<Daily> list = new ArrayList<>();
    List<HourseWeather> list12 = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
   DailyForecastAdapter dailyForecastAdapter;
   H12Adapter h12Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

        tvCategory = findViewById(R.id.tvCategory);
        tvEndDate = findViewById(R.id.tvEndDate);

        //list  = new ArrayList<>();

        dailyForecastAdapter = new DailyForecastAdapter(MainActivity.this,list,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
         recyclerView = findViewById(R.id.rcListWeather);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(dailyForecastAdapter);

        get12House();
        h12Adapter = new H12Adapter(MainActivity.this,list12);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this,RecyclerView.VERTICAL,true);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,8);
        recyclerView1 = findViewById(R.id.rcList12H);
        recyclerView1.setLayoutManager(gridLayoutManager1);
        recyclerView1.setAdapter(h12Adapter);


    }

    private void getData()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIManager service = retrofit.create(APIManager.class);
        service.get5Day().enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather model = response.body();
                tvCategory.setText("Dự Báo Thời Tiết "+model.getHeadline().getSeverity()+" Day");
                tvEndDate.setText(model.getHeadline().getEffectiveDate().substring(0,10)+" Đến "+model.getHeadline().getEndDate().substring(0,10));

                    if (response.body()!=null)
                    {
                         list = model.getDaily();
                        dailyForecastAdapter.reloadData(list);
                    }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("MainActivity","onFailure: 1 "+t);
            }
        });
    }
    private void get12House()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIManager service = retrofit.create(APIManager.class);
        service.get12Hour().enqueue(new Callback<List<HourseWeather>>() {
            @Override
            public void onResponse(Call<List<HourseWeather>> call, Response<List<HourseWeather>> response) {
                if (response.body()!=null)
                {
                    list12 = response.body();
                    h12Adapter.reloadData(list12);
                }
            }

            @Override
            public void onFailure(Call<List<HourseWeather>> call, Throwable t) {

            }
        });
    }

    private void goToWeather(String day,int img,String temperature,String min,String max,String toDay,String dayWT,String nightWT)
    {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("DAY",day);
        intent.putExtra("IMG",img);
        intent.putExtra("TEM",temperature);
        intent.putExtra("MIN",min);
        intent.putExtra("MAX",max);
        intent.putExtra("TODAY",toDay);
        intent.putExtra("DAYWT",dayWT);
        intent.putExtra("NIGHTWT",nightWT);
        startActivity(intent);
    }


    @Override
    public void onClickItem(int position) {
         Daily daily = list.get(position);
        Context c = getApplicationContext();
        int img = c.getResources().getIdentifier("drawable/"+"w"+String.valueOf(daily.getDay().getIcon()),null,c.getPackageName());
        String day = "Day "+daily.getDate().substring(8,10);
        String temp = String.valueOf(daily.getTemperature().getMinimum().getValue())+"C - "+String.valueOf(daily.getTemperature().getMaximum().getValue())+"C";
        String min =  String.valueOf(daily.getTemperature().getMinimum().getValue())+"C ";
        String max =  String.valueOf(daily.getTemperature().getMaximum().getValue())+"C ";
        String toDay = daily.getDate().substring(0,10);
        String dayWT = daily.getDay().getIconPhrase();
        String nightWT = daily.getNight().getIconPhrase();
        Toast.makeText(this,day,Toast.LENGTH_SHORT).show();
        goToWeather(day,img,temp,min,max,toDay,dayWT,nightWT);
    }
}
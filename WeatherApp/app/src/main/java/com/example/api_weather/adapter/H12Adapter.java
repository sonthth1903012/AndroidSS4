package com.example.api_weather.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api_weather.R;
import com.example.api_weather.model.hourse12.HourseWeather;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class H12Adapter extends RecyclerView.Adapter {
    Activity activity;
    List<HourseWeather> list;

    public H12Adapter(Activity activity, List<HourseWeather> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<HourseWeather> list)
    {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.actitvity_12h,parent,false);
        HouseWeatherHolder holder = new HouseWeatherHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HouseWeatherHolder hd = (HouseWeatherHolder) holder;
        HourseWeather model = list.get(position);
        Context c = activity.getApplicationContext();
        int img = c.getResources().getIdentifier("drawable/"+"w"+String.valueOf(model.getWeatherIcon()),null,c.getPackageName());
        hd.tvHour.setText(model.getDateTime().substring(11,13));
        hd.ivIcon12.setImageResource(img);
        hd.tvValue12.setText(String.valueOf(model.temperature.getValue())+" °C");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HouseWeatherHolder extends RecyclerView.ViewHolder{
        TextView tvHour,tvValue12;
        ImageView ivIcon12;


        public HouseWeatherHolder(@NonNull  View itemView) {
            super(itemView);
            tvHour = (TextView) itemView.findViewById(R.id.tvHour);
            tvValue12 = (TextView) itemView.findViewById(R.id.tvValue12);
            ivIcon12 = (ImageView) itemView.findViewById(R.id.ivIcon12);
        }
    }
}

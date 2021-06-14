package com.example.api_weather.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api_weather.IOnClickItem;
import com.example.api_weather.R;
import com.example.api_weather.model.Daily;
import com.example.api_weather.model.DailyForecast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyForecastAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Daily> list;
    private IOnClickItem iOnClickItem;

//    public DailyForecastAdapter(Activity activity, List<Daily> list) {
//        this.activity = activity;
//        this.list = list;
//    }

    public DailyForecastAdapter(Activity activity, List<Daily> list, IOnClickItem iOnClickItem) {
        this.activity = activity;
        this.list = list;
        this.iOnClickItem = iOnClickItem;
    }

    public void reloadData(List<Daily> list)
    {
        this.list = list;
        this.notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_list_weather_5day,parent,false);
        DailyForecastHolder holder = new DailyForecastHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DailyForecastHolder hd = (DailyForecastHolder) holder;
        Daily model = list.get(position);
        //String[] date = model.getDate().split("T",2);
        Context c = activity.getApplicationContext();
        int img = c.getResources().getIdentifier("drawable/"+"w"+String.valueOf(model.getDay().getIcon()),null,c.getPackageName());

        hd.tvEpochDate.setText("Day "+model.getDate().substring(8,10));
        hd.ivIcon.setImageResource(img);
        hd.tvIconPhrase.setText(String.valueOf(model.getTemperature().getMinimum().getValue())+"°C - "+String.valueOf(model.getTemperature().getMaximum().getValue())+"°C");
        hd.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItem.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DailyForecastHolder extends RecyclerView.ViewHolder
    {
        TextView tvEpochDate,tvIconPhrase;
        ImageView ivIcon;
        public DailyForecastHolder(@NonNull  View itemView) {
            super(itemView);
            tvEpochDate = (TextView) itemView.findViewById(R.id.tvEpochDate);
            tvIconPhrase = (TextView)  itemView.findViewById(R.id.tvIconPhrase);
            ivIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
        }
    }
}

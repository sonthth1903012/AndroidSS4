package com.example.api_weather;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvCategory = findViewById(R.id.tvDayDt);
        TextView tvEndDate = findViewById(R.id.tvTMDT);
        TextView tvMin = findViewById(R.id.tvMin);
        TextView tvMax = findViewById(R.id.tvMax);
        TextView tvDay = findViewById(R.id.tvDay);
        TextView tvDayWT = findViewById(R.id.tvDayWT);
        TextView tvNightWT = findViewById(R.id.tvNightWT);
        Intent intent = getIntent();
        String day = intent.getStringExtra("DAY");
        int img = intent.getIntExtra("IMG",0);
        String temp = intent.getStringExtra("TEM");
        String min = intent.getStringExtra("MIN");
        String max = intent.getStringExtra("MAX");
        String toDay = intent.getStringExtra("TODAY");
        String dayWT = intent.getStringExtra("DAYWT");
        String nightWT = intent.getStringExtra("NIGHTWT");
        tvMin.setText(min);
        tvMax.setText(max);
        tvCategory.setText(day);
        tvEndDate.setText(temp);
        ImageView ivBk = findViewById(R.id.ivBk);
        ivBk.setImageResource(img);
        tvDay.setText(toDay);
        tvDayWT.setText(dayWT);
        tvNightWT.setText(nightWT);
    }
}

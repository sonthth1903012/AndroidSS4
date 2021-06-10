package com.example.ss7_networking_recycledview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ss7_networking_recycledview.adapter.NewsAdapter;
import com.example.ss7_networking_recycledview.model.Item;
import com.example.ss7_networking_recycledview.network.APIManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ListNewsActivity extends AppCompatActivity {

    RecyclerView rvListNews;
    List<Item> listData;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        //B1: Data source
        getListData();

        //B2: Adapter
        listData = new ArrayList<>();
        adapter = new NewsAdapter(ListNewsActivity.this, listData);

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //B4: RecyclerView
        rvListNews = findViewById(R.id.rvListNews);
        rvListNews.setLayoutManager(layoutManager);
        rvListNews.setAdapter(adapter);

    }


    private void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(new GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() != null) {
                    listData = response.body();
                    adapter.reloadData(listData);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(ListNewsActivity.this,"Fail", Toast.LENGTH_LONG).show();
            }
        });
    }

}

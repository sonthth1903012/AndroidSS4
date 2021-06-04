package com.example.shoppping_layout_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem{

    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super. onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //B1: Data Source
        initData();

        //B2: Adapter
        ProductAdapter adapter = new ProductAdapter(this,listProduct,this);

        //B3: LayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        //B4: RecyclerView
        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);

    }


    private void initData() {
        listProduct.add(new Product("Nike SS1","Walk on the air!","1600.00",R.drawable.p1));
        listProduct.add(new Product("Nike SS2","Walk on the air!","1700.00",R.drawable.p2));
        listProduct.add(new Product("Nike SS3","Walk on the air!","1800.00",R.drawable.p3));
        listProduct.add(new Product("Nike SS4","Walk on the air!","1900.00",R.drawable.p4));
        listProduct.add(new Product("Nike SS5","Walk on the air!","2000.00",R.drawable.p5));
        listProduct.add(new Product("Nike SS6","Walk on the air!","2100.00",R.drawable.p6));
        listProduct.add(new Product("Nike SS7","Walk on the air!","2200.00",R.drawable.p1));
        listProduct.add(new Product("Nike SS8","Walk on the air!","2300.00",R.drawable.p2));
        listProduct.add(new Product("Nike SS9","Walk on the air!","2400.00",R.drawable.p3));
        listProduct.add(new Product("Nike SS10","Walk on the air!","2500.00",R.drawable.p4));
    }

    //Handle when click item RecycleView
    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this,product.getTitle(),Toast.LENGTH_SHORT).show();
    }
}

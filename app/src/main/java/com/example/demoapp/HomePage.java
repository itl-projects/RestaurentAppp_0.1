package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    RecyclerView Recycleview;
    private List <DataModel> list = new ArrayList <>();
    private CustomAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Recycleview = findViewById(R.id.recycle);
        adaptor = new CustomAdaptor(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        Recycleview.setLayoutManager(layoutManager);
        Recycleview.setItemAnimator(new DefaultItemAnimator());
        Recycleview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        Recycleview.setAdapter(adaptor);
        PrepareData();
    }

    public void PrepareData() {
        DataModel listItems = new DataModel("shop1", R.drawable.shop);
        list.add(listItems);

        DataModel listItems1 = new DataModel("shop2", R.drawable.shop);
        list.add(listItems1);
        DataModel listItems2 = new DataModel("shop3", R.drawable.shop);
        list.add(listItems2);
        DataModel listItems3 = new DataModel("shop4", R.drawable.shop);
        list.add(listItems3);
        DataModel listItems4 = new DataModel("shop5", R.drawable.shop);
        list.add(listItems4);
        DataModel listItems5 = new DataModel("shop6", R.drawable.shop);
        list.add(listItems5);
        adaptor.notifyDataSetChanged();
    }
}
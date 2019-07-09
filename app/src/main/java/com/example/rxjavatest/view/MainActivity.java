package com.example.rxjavatest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rxjavatest.R;
import com.example.rxjavatest.model.PojoCake;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewContract {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void getListCakes(List<PojoCake> dataSet) {
        adapter.setDataset(dataSet);
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new
                GridLayoutManager(this, 2));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }
}

package com.example.rxjavatest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rxjavatest.R;
import com.example.rxjavatest.model.PojoCake;
import com.example.rxjavatest.presenter.Presenter;
import com.example.rxjavatest.presenter.PresenterContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewContract {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        initUI();
        presenter.bindView(this);
        presenter.initNetworkCall();
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

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unBind();
    }
}

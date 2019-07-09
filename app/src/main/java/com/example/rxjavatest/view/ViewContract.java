package com.example.rxjavatest.view;

import com.example.rxjavatest.model.PojoCake;

import java.util.List;

public interface ViewContract {
    void getListCakes(List<PojoCake> dataSet);
    void initUI();
}

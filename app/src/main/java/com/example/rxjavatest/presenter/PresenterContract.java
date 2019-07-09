package com.example.rxjavatest.presenter;

import com.example.rxjavatest.view.ViewContract;

public interface PresenterContract {
    void bindView(ViewContract view);
    void unBind();
    void initNetworkCall();
}

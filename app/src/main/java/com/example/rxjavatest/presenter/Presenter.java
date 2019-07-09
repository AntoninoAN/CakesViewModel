package com.example.rxjavatest.presenter;

import com.example.rxjavatest.model.ApiInterface;
import com.example.rxjavatest.model.Network;
import com.example.rxjavatest.model.PojoCake;
import com.example.rxjavatest.view.ViewContract;

import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class Presenter implements PresenterContract {
    private ViewContract view;
    private Network network;

    @Override
    public void bindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        view = null;
    }

    @Override
    public void initNetworkCall() {
        network = new Network();
        ApiInterface apiInterface =
        network.getItems();
        apiInterface
                .getCakes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PojoCake>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<PojoCake> pojoCakes) {
                        view.getListCakes(pojoCakes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

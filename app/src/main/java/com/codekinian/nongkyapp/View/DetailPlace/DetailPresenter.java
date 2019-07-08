package com.codekinian.nongkyapp.View.DetailPlace;

import android.app.Activity;
import android.content.Intent;

import com.codekinian.nongkyapp.Base.BasePresenter;
import com.codekinian.nongkyapp.Model.GoogleDetailModel.GDetailModel;
import com.codekinian.nongkyapp.Model.GoogleDetailModel.GDetailResult;
import com.codekinian.nongkyapp.Network.NetworkCallback;


public class DetailPresenter extends BasePresenter<DetailView> {

    DetailPresenter(DetailView view) {
        super.attachView(view);
    }

    void loadData(String place_id, String key, String lang) {
        view.showLoading();
        addSubscribe(apiStores.getDetail(key, place_id, lang), new NetworkCallback<GDetailModel>() {
            @Override
            public void onSuccess(GDetailModel model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }


}

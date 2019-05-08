package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

class MainViewModel extends ViewModel {

    private static final float usd_to_eu_rate = 0.75f;
    private String mDollarText = "";
    private final MutableLiveData<Float> mResult = new MutableLiveData<>();

    void setAmount(String value) {
        mDollarText = value;
        mResult.setValue(Float.valueOf(mDollarText) * usd_to_eu_rate);
    }

    MutableLiveData<Float> getResult() {
        return mResult;
    }
}

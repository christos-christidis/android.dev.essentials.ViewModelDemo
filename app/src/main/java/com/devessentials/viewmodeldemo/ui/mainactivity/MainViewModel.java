package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.ViewModel;

class MainViewModel extends ViewModel {

    private static final float usd_to_eu_rate = 0.75f;
    private String mDollarText = "";
    private Float mResult = 0f;

    void setAmount(String value) {
        mDollarText = value;
        mResult = Float.valueOf(mDollarText) * usd_to_eu_rate;
    }

    Float getResult() {
        return mResult;
    }
}

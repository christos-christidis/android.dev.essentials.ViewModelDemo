package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel {

    private static final float usd_to_eu_rate = 0.75f;
    private String mDollarString = "";
    private final MutableLiveData<Float> mResult = new MutableLiveData<>();

    // SOS: both getDollarString and getResult are called when the layout is (re)created. But because
    // getResult returns LiveData, it's also called whenever mResult is changed in-code! For this to
    // work though, we must make the binding observe the lifecycle of the fragment (MainFragment.java)
    public String getDollarString() {
        Log.i("WTF", "getDollarString");
        return mDollarString;
    }

    // SOS: mDollarString is 2-way bound, so changing the EditText calls setDollarString. This changes
    // mResult, so getResult will also be called.
    public void setDollarString(String s) {
        Log.i("WTF", "setDollarString");
        mDollarString = s;
        if (mDollarString.equals("")) {
            mResult.setValue(0f);
        } else {
            mResult.setValue(Float.valueOf(mDollarString) * usd_to_eu_rate);
        }
    }

    public LiveData<Float> getResult() {
        Log.i("WTF", "getResult");
        return mResult;
    }
}

package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devessentials.viewmodeldemo.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private EditText mDollarText;
    private TextView mResultText;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        View view = getView();
        if (view == null) return;
        mDollarText = getView().findViewById(R.id.dollarText);
        mResultText = getView().findViewById(R.id.resultText);
        Button convertButton = getView().findViewById(R.id.convertButton);

        mResultText.setText(mViewModel.getResult().toString());

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDollarText.getText().toString().equals("")) {
                    mResultText.setText(R.string.no_value);
                } else {
                    mViewModel.setAmount(mDollarText.getText().toString());
                    mResultText.setText(mViewModel.getResult().toString());
                }
            }
        });
    }
}

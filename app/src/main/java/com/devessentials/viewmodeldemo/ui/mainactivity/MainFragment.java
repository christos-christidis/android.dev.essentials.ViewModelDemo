package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.Observer;
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

        final Observer<Float> resultObserver = new Observer<Float>() {
            @Override
            public void onChanged(@Nullable Float result) {
                if (result != null) {
                    mResultText.setText(result.toString());
                }
            }
        };

        // The LiveData observes the lifecycle of this fragment. resultObserver will be called when
        // a) the data changes while the fragment is active and b) when the fragment goes from
        // inactive to active (active = started or resumed).
        mViewModel.getResult().observe(this, resultObserver);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDollarText.getText().toString().equals("")) {
                    mResultText.setText(R.string.no_value);
                } else {
                    mViewModel.setAmount(mDollarText.getText().toString());

                    // SOS: No need for this. setAmount changes the LiveData, which in turn calls
                    // resultObserver which updates the view...
//                    mResultText.setText(mViewModel.getResult().toString());
                }
            }
        });
    }
}

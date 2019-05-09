package com.devessentials.viewmodeldemo.ui.mainactivity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devessentials.viewmodeldemo.R;
import com.devessentials.viewmodeldemo.databinding.MainFragmentBinding;

import static com.devessentials.viewmodeldemo.BR.viewModel;

public class MainFragment extends Fragment {

    private MainFragmentBinding mBinding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);

        mBinding.setLifecycleOwner(this);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainViewModel myViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mBinding.setVariable(viewModel, myViewModel);
    }
}

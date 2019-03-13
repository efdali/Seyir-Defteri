package com.punwald.seyirdefteri.common;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseVMFragment<VM extends ViewModel> extends Fragment {

    protected VM viewModel;

    protected abstract Class<VM> getViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(getViewModel());
    }
}

package com.punwald.seyirdefteri.common;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<DB extends ViewDataBinding,VM extends ViewModel> extends AppCompatActivity {


    protected DB dataBinding;
    protected VM viewModel;


    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract Class<VM> getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding= DataBindingUtil.setContentView(this,getLayoutRes());
        viewModel= ViewModelProviders.of(this).get(getViewModel());

    }
}

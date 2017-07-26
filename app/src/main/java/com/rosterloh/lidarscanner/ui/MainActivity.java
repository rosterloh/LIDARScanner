package com.rosterloh.lidarscanner.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rosterloh.lidarscanner.R;
import com.rosterloh.lidarscanner.databinding.MainActivityBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setCallback((direction) -> mViewModel.move(direction));
    }
}

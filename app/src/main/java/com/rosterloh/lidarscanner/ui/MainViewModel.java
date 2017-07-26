package com.rosterloh.lidarscanner.ui;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import timber.log.Timber;

public class MainViewModel extends ViewModel {

    @Inject
    MainViewModel() {

    }

    void move(int direction) {
        switch (direction) {
            case 0:
                Timber.d("Move left");
                break;
            case 1:
                Timber.d("Move up");
                break;
            case 2:
                Timber.d("Move right");
                break;
            default:
                Timber.d("Move down");
                break;
        }
    }
}

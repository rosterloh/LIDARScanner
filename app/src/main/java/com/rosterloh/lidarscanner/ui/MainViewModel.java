package com.rosterloh.lidarscanner.ui;

import android.arch.lifecycle.ViewModel;

import com.rosterloh.lidarscanner.sensors.HardwareComponents;

import javax.inject.Inject;

import timber.log.Timber;

public class MainViewModel extends ViewModel {

    private HardwareComponents mHardware;

    @Inject
    MainViewModel(HardwareComponents hardwareComponents) {
        mHardware = hardwareComponents;
    }

    void move(int direction) {
        switch (direction) {
            case 0:
                Timber.d("Move left");
                mHardware.moveHorizontal(0.0);
                break;
            case 1:
                Timber.d("Move up");
                break;
            case 2:
                Timber.d("Move right");
                mHardware.moveHorizontal(180.0);
                break;
            default:
                Timber.d("Move down");
                break;
        }
    }
}

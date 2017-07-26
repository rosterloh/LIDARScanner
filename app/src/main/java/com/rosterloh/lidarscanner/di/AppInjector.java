package com.rosterloh.lidarscanner.di;

import com.rosterloh.lidarscanner.App;

public class AppInjector {

    public static void init(App app) {
        DaggerAppComponent.builder()
                .application(app)
                .build()
                .inject(app);
    }
}

package com.rosterloh.lidarscanner.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
class AppModule {

    @Singleton
    @Provides
    Context provideContext(Application app) {
        return app.getApplicationContext();
    }

}

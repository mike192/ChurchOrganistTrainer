package pl.mosenko.churchorganisttrainer;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import pl.mosenko.churchorganisttrainer.data.AppDatabaseModule;
import pl.mosenko.churchorganisttrainer.di.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by syk on 16.10.17.
 */

public class AndroidApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        initializeDIComponent();
    }

    private void initializeDIComponent() {
        DaggerAppComponent
                .builder()
                .appDatabaseModule(new AppDatabaseModule(this))
                .build()
                .inject(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}

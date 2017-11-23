package pl.mosenko.churchorganisttrainer.presentation.common.view;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.di.annotations.PerActivity;

/**
 * Created by syk on 20.11.17.
 */

@Module
public abstract class BaseActivityModule {

    public static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";
    public static final String ACTIVITY_CONTEXT = "BaseActivityModule.activityContext";

    @Binds
    @Named(ACTIVITY_CONTEXT)
    @PerActivity
    abstract Context activityContext(AppCompatActivity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }
}

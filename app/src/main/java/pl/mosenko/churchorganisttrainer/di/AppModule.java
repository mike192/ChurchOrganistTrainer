package pl.mosenko.churchorganisttrainer.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import pl.mosenko.churchorganisttrainer.AndroidApplication;
import pl.mosenko.churchorganisttrainer.data.AppDatabaseModule;
import pl.mosenko.churchorganisttrainer.di.annotations.PerActivity;
import pl.mosenko.churchorganisttrainer.presentation.MainActivity;

/**
 * Created by syk on 16.10.17.
 */

@Module(includes = {AndroidInjectionModule.class, AppDatabaseModule.class})
abstract class AppModule {

    @Binds
    @Singleton
    abstract Application application(AndroidApplication app);

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();
}

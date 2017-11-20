package pl.mosenko.churchorganisttrainer.di;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pl.mosenko.churchorganisttrainer.di.annotations.PerActivity;
import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.presentation.MainActivity;
import pl.mosenko.churchorganisttrainer.presentation.common.view.BaseActivityModule;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationFragment;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationViewModule;

/**
 * Created by syk on 20.11.17.
 */

@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = InvocationViewModule.class)
    abstract InvocationFragment invocationFragmentInjector();

    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity mainActivity);

}

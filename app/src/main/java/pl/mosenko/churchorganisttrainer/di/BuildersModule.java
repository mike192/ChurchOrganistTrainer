package pl.mosenko.churchorganisttrainer.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationActivity;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationModule;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationViewModule;

/**
 * Created by syk on 16.10.17.
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {InvocationViewModule.class, InvocationModule.class})
    abstract InvocationActivity bindInvocationActivity();
}

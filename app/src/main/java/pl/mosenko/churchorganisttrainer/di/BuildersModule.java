package pl.mosenko.churchorganisttrainer.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationFragment;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationModule;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationViewBindingModule;

/**
 * Created by syk on 16.10.17.
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {InvocationViewBindingModule.class, InvocationModule.class})
    abstract InvocationFragment bindInvocationActivity();
}

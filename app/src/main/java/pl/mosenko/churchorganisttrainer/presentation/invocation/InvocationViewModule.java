package pl.mosenko.churchorganisttrainer.presentation.invocation;

import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.presentation.common.view.BaseFragmentModule;

/**
 * Created by syk on 16.10.17.
 */

@Module(includes = {BaseFragmentModule.class, InvocationPresenterModule.class})
public abstract class InvocationViewModule {

    @Binds
    @PerFragment
    abstract Fragment provideInvocationFragment(InvocationFragment invocationFragment);

    @Binds
    @PerFragment
    abstract InvocationContract.View provideInvocationView(InvocationFragment invocationFragment);
}

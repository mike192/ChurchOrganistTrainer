package pl.mosenko.churchorganisttrainer.presentation.invocation;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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

    @Provides
    @PerFragment
    public static InvocationAdapter provideInvocationAdapter() {
        return new InvocationAdapter();
    }
}

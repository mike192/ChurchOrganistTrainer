package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Binds;
import dagger.Module;
import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;

/**
 * Created by syk on 20.11.17.
 */

@Module
public abstract class InvocationPresenterModule {

    @Binds
    @PerFragment
    abstract InvocationContract.Presenter provideInvocationPresenterModule(InvocationPresenter invocationPresenter);
}
package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationRepository;
import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.domain.GetInvocations;

/**
 * Created by syk on 20.11.17.
 */

@Module
public abstract class InvocationPresenterModule {

    @Binds
    @PerFragment
    abstract InvocationContract.Presenter provideInvocationPresenterModule(InvocationPresenter invocationPresenter);

    @Provides
    @PerFragment
    public static GetInvocations provideGetInvocations(InvocationRepository invocationRepository) {
        return new GetInvocations(invocationRepository);
    }
}
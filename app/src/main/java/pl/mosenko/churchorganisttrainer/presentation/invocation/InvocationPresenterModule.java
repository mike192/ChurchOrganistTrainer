package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationRepository;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationStatisticRepository;
import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.domain.services.InvocationMainMapper;
import pl.mosenko.churchorganisttrainer.domain.usecase.GetMainInvocationList;

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
    public static GetMainInvocationList provideGetInvocations(InvocationRepository invocationRepository, InvocationStatisticRepository statisticRepository, InvocationMainMapper invocationMainMapper) {
        return new GetMainInvocationList(invocationRepository, statisticRepository, invocationMainMapper);
    }
}
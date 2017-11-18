package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.data.repository.ToneRepository;

/**
 * Created by syk on 16.10.17.
 */

@Module
public class InvocationModule {

    @Provides
    InvocationContract.Presenter provideInvocationPresenter(InvocationContract.View invocationView) {
        return new InvocationPresenter(invocationView);
    }
}

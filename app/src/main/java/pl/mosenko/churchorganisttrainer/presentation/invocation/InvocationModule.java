package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Module;
import dagger.Provides;

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

package pl.mosenko.churchorganisttrainer.presentation.invocation;

import dagger.Binds;
import dagger.Module;

/**
 * Created by syk on 16.10.17.
 */

@Module
public abstract class InvocationViewModule {

    @Binds
    abstract InvocationContract.View provideInvocationView(InvocationActivity invocationActivity);
}

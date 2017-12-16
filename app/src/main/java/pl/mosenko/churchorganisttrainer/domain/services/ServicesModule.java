package pl.mosenko.churchorganisttrainer.domain.services;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by syk on 16.12.17.
 */

@Module
public class ServicesModule {

    @Provides
    @Singleton
    protected InvocationMainMapper provideInvocationMainMapper() {
        return new InvocationMainMapper();
    }
}

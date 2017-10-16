package pl.mosenko.churchorganisttrainer.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.AndroidApplication;

/**
 * Created by syk on 16.10.17.
 */

@Module
public class AppModule {

    @Provides
    Context provideContext(AndroidApplication androidApplication) {
        return androidApplication.getApplicationContext();
    }

}

package pl.mosenko.churchorganisttrainer.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;
import pl.mosenko.churchorganisttrainer.AndroidApplication;
import pl.mosenko.churchorganisttrainer.data.AppDatabaseModule;

/**
 * Created by syk on 16.10.17.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class,
        AppDatabaseModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AndroidApplication androidApplication);

        AppComponent build();
    }

    void inject(AndroidApplication androidApplication);
}

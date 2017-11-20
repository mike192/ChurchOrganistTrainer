package pl.mosenko.churchorganisttrainer.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.mosenko.churchorganisttrainer.AndroidApplication;

/**
 * Created by syk on 16.10.17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(AndroidApplication androidApplication);
}

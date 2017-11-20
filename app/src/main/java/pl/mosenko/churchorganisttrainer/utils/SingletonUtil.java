package pl.mosenko.churchorganisttrainer.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by syk on 20.11.17.
 */

@Singleton
public final class SingletonUtil {

    @Inject
    SingletonUtil() {
    }

    public String doSomething() {
        return "SingletonUtil: " + hashCode();
    }
}
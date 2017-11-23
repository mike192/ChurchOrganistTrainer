package pl.mosenko.churchorganisttrainer.data;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.data.dao.InvocationDao;
import pl.mosenko.churchorganisttrainer.data.dao.ToneDao;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationDataSource;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationRepository;
import pl.mosenko.churchorganisttrainer.data.repository.ToneDataSource;
import pl.mosenko.churchorganisttrainer.data.repository.ToneRepository;

/**
 * Created by syk on 15.11.17.
 */

@Module
public class AppDatabaseModule {

    public static final String APP_CONTEXT = "AppModule.context";
    private Application application;

    public AppDatabaseModule(Application application) {
        this.application = application;
    }

    @Provides
    @Named(APP_CONTEXT)
    @Singleton
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    public AppDatabaseCallback provideAppDatabaseCallback(@Named(APP_CONTEXT) Context context) {
        return new AppDatabaseCallback(context);
    }

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(@Named(APP_CONTEXT) Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, AppDatabase.DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    public ToneDao provideToneDao(AppDatabase appDatabase) {
        return appDatabase.getToneDao();
    }

    @Singleton
    @Provides
    public ToneRepository provideToneRepository(ToneDao toneDao) {
        return new ToneDataSource(toneDao);
    }

    @Singleton
    @Provides
    public InvocationDao provideInvocationDao(AppDatabase appDatabase) {
        return appDatabase.getInvocationDao();
    }

    @Singleton
    @Provides
    public InvocationRepository provideInvocationRepository(InvocationDao invocationDao) {
        return new InvocationDataSource(invocationDao);
    }
}

package pl.mosenko.churchorganisttrainer.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.mosenko.churchorganisttrainer.data.dao.ToneDao;
import pl.mosenko.churchorganisttrainer.data.repository.ToneDataSource;
import pl.mosenko.churchorganisttrainer.data.repository.ToneRepository;

/**
 * Created by syk on 15.11.17.
 */

@Module
public class AppDatabaseModule {

    @Singleton
    @Provides
    public AppDatabaseCallback provideAppDatabaseCallback(Context context) {
       return new AppDatabaseCallback(context);
    }

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(Context context) {
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

}

package pl.mosenko.churchorganisttrainer.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import pl.mosenko.churchorganisttrainer.data.dao.InvocationDao;
import pl.mosenko.churchorganisttrainer.data.dao.InvocationsStatisticDao;
import pl.mosenko.churchorganisttrainer.data.dao.ToneDao;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;
import pl.mosenko.churchorganisttrainer.data.entities.InvocationTone;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;
import pl.mosenko.churchorganisttrainer.utils.DateTypeConverter;

@Database(entities = {Invocation.class, InvocationTone.class, Tone.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "invocations.db";
    private static volatile AppDatabase INSTANCE;

    public abstract ToneDao toneDao();

    public abstract InvocationDao invocationDao();

    public abstract InvocationsStatisticDao invocationsStatisticDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}

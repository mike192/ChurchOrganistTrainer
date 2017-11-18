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
import pl.mosenko.churchorganisttrainer.data.entities.InvocationsStatistic;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;
import pl.mosenko.churchorganisttrainer.data.entities.TonesStatistic;
import pl.mosenko.churchorganisttrainer.utils.DateTypeConverter;

@Database(entities = {Invocation.class, InvocationTone.class, Tone.class,
        TonesStatistic.class, InvocationsStatistic.class}, version = AppDatabase.VERSION)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "invocations.db";
    static final int VERSION = 1;

    public abstract ToneDao getToneDao();

    public abstract InvocationDao getInvocationDao();

    public abstract InvocationsStatisticDao getInvocationsStatisticDao();
}

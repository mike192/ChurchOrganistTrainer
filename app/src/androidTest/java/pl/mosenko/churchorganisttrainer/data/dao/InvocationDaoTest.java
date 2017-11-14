package pl.mosenko.churchorganisttrainer.data.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import pl.mosenko.churchorganisttrainer.data.AppDatabase;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;

/**
 * Created by syk on 14.10.17.
 */
@RunWith(AndroidJUnit4.class)
public class InvocationDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AppDatabase appDatabase;

    @Before
    public void setupDb() {
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }

    @Test
    public void shouldInsertMethodAddInvocationToDb() {
        //Given
        Invocation invocation = new Invocation();
        invocation.setAuthor("author");
        invocation.setCreatedAt(new Date());
        invocation.setInvocationName("Invocation1");

        Tone tone1 = new Tone();
        tone1.setToneNamePL("C1");
        tone1.setToneNameUS("C1");

        Tone tone2 = new Tone();
        tone2.setToneNamePL("D2");
        tone2.setToneNameUS("D2");

     //   appDatabase.toneDao().insert(tone1);

        //When
        InvocationDao invocationDao = appDatabase.invocationDao();
        invocationDao.insert(invocation);
        //Then
        invocationDao.getInvocations().test().assertValue(invocations
                -> invocations.get(0)
                .getInvocationName().equals(invocation.getInvocationName()));
    }

}
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
        //When
        InvocationDao invocationDao = appDatabase.invocationDao();
        invocationDao.insert(invocation);
        //Then
        invocationDao.getInvocations().test().assertValue(invocations
                -> invocations.get(0).getInvocationName().equals(invocation.getInvocationName()));
    }

}
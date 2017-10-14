package pl.mosenko.churchorganisttrainer;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import io.reactivex.functions.Predicate;
import pl.mosenko.churchorganisttrainer.data.AppDatabase;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;

@RunWith(AndroidJUnit4.class)
public class DbDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AppDatabase appDatabase;

    @Before
    public void initDb() {
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @Test
    public void testInsertAndQueryTone() {
        final Tone tone1 = new Tone();
        tone1.setToneNamePL("h");
        tone1.setToneNameUS("b");
        appDatabase.toneDao().insert(tone1);

        appDatabase.toneDao().getTones()
                .test()
                .assertValue(new Predicate<List<Tone>>() {
                    @Override
                    public boolean test(List<Tone> tones) throws Exception {
                        return tones.get(0).getToneNamePL().equals(tone1.getToneNamePL());
                    }
                });
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }


}

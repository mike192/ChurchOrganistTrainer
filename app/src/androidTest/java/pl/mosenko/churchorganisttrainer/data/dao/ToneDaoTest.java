package pl.mosenko.churchorganisttrainer.data.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import io.reactivex.functions.Predicate;
import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.data.AppDatabase;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;
import pl.mosenko.churchorganisttrainer.utils.RawResourceUtil;

@RunWith(AndroidJUnit4.class)
public class ToneDaoTest {

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
        appDatabase.getToneDao().insert(tone1);

        appDatabase.getToneDao().getTones()
                .test()
                .assertValue(new Predicate<List<Tone>>() {
                    @Override
                    public boolean test(List<Tone> tones) throws Exception {
                        return tones.get(0).getToneNamePL().equals(tone1.getToneNamePL());
                    }
                });
    }

    @Test
    public void testReadInitTones() {
        //Given
        String tonesJson = RawResourceUtil.readRawTextFile(InstrumentationRegistry.getTargetContext(), R.raw.tones);
        //When
        List<Tone> toneList = new Gson().fromJson(tonesJson, new TypeToken<List<Tone>>(){}.getType());
        //Then
        int i = 1;
        for (Tone tone : toneList) {
            Assert.assertEquals(i, tone.getId());
            System.out.println(tone);
            i++;
        }
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }


}

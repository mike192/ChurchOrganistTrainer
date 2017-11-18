package pl.mosenko.churchorganisttrainer.data.repository;

import android.arch.persistence.room.Index;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.dao.ToneDao;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;

/**
 * Created by syk on 15.11.17.
 */

public class ToneDataSource implements ToneRepository {

    private ToneDao toneDao;

    @Inject
    public ToneDataSource(ToneDao toneDao) {
        this.toneDao = toneDao;
    }


    @Override
    public Maybe<List<Tone>> getTones() {
        return toneDao.getTones();
    }

    @Override
    public Maybe<Tone> getToneById(int toneId) {
        return toneDao.getToneById(toneId);
    }

    @Override
    public Maybe<Long> insert(Tone tone) {
        return Maybe.fromCallable(() -> toneDao.insert(tone));
    }

    @Override
    public Maybe<List<Long>> insertAll(List<Tone> tone) {
        return Maybe.fromCallable(() -> toneDao.insertAll(tone));
    }

    @Override
    public Maybe<Integer> delete(Tone tone) {
        return Maybe.fromCallable(() -> toneDao.delete(tone));
    }
}

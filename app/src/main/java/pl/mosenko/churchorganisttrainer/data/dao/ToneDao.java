package pl.mosenko.churchorganisttrainer.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;

@Dao
public interface ToneDao {

    @Query("SELECT * FROM tones")
    Maybe<List<Tone>> getTones();

    @Query("SELECT * FROM tones WHERE id = :toneId")
    Maybe<Tone> getToneById(int toneId);

    @Insert
    Long insert(Tone tone);

    @Insert
    List<Long> insertAll(List<Tone> tones);

    @Delete
    int delete(Tone tone);
}

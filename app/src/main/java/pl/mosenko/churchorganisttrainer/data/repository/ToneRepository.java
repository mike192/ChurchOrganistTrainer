package pl.mosenko.churchorganisttrainer.data.repository;

import java.util.List;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;

/**
 * Created by syk on 15.11.17.
 */

public interface ToneRepository {
    Maybe<List<Tone>> getTones();

    Maybe<Tone> getToneById(int toneId);

    Maybe<Long> insert(Tone tone);

    Maybe<List<Long>> insertAll(List<Tone> tones);

    Maybe<Integer> delete(Tone tone);
}

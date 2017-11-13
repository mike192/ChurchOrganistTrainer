package pl.mosenko.churchorganisttrainer.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.InvocationsStatistic;

/**
 * Created by syk on 13.11.17.
 */

@Dao
public interface InvocationsStatisticDao {
    @Query("select * from invocations_statistic " +
            "where invocation_id = :invocationId and date_of_exercise = " +
            "(select max(date_of_exercise) from invocations_statistic " +
            "where invocation_id = :invocationId)")
    Maybe<InvocationsStatistic> getLastInvocationsStatisticForInvocation(int invocationId);

    @Insert
    void insert(InvocationsStatistic invocationsStatistic);
}

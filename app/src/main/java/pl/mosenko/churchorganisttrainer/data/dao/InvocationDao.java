package pl.mosenko.churchorganisttrainer.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;

/**
 * Created by syk on 14.10.17.
 */

@Dao
public interface InvocationDao {

    @Query("select * from invocations")
    Maybe<List<Invocation>> getInvocations();

    @Query("select * from invocations where id = :invocationId")
    Maybe<Invocation> getInvocationById(int invocationId);

    @Insert
    void insert(Invocation invocation);

    @Delete
    void delete(Invocation invocation);
}

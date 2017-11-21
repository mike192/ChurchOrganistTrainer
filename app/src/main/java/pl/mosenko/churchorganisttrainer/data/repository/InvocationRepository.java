package pl.mosenko.churchorganisttrainer.data.repository;

import java.util.List;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;

/**
 * Created by syk on 21.11.17.
 */

public interface InvocationRepository {

    Maybe<List<Invocation>> getInvocations();

    Maybe<Invocation> getInvocationById(int invocationId);

    Maybe<Long> insert(Invocation invocation);

    Maybe<Integer> delete(Invocation invocation);

    Maybe<List<Long>> insertAll(List<Invocation> invocations);
}

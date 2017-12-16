package pl.mosenko.churchorganisttrainer.data.repository;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.InvocationsStatistic;

/**
 * Created by syk on 16.12.17.
 */

public interface InvocationStatisticRepository {
    Maybe<InvocationsStatistic> getLastInvocationsStatisticForInvocation(int invocationId);

    Maybe<Long> insert(InvocationsStatistic invocationsStatistic);
}

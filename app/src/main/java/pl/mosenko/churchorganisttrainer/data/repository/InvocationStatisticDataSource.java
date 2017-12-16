package pl.mosenko.churchorganisttrainer.data.repository;

import javax.inject.Inject;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.dao.InvocationsStatisticDao;
import pl.mosenko.churchorganisttrainer.data.entities.InvocationsStatistic;

/**
 * Created by syk on 16.12.17.
 */

public class InvocationStatisticDataSource implements InvocationStatisticRepository {

    private InvocationsStatisticDao invocationsStatisticDao;

    @Inject
    public InvocationStatisticDataSource(InvocationsStatisticDao invocationsStatisticDao) {
        this.invocationsStatisticDao = invocationsStatisticDao;
    }

    @Override
    public Maybe<InvocationsStatistic> getLastInvocationsStatisticForInvocation(int invocationId) {
        return invocationsStatisticDao.getLastInvocationsStatisticForInvocation(invocationId);
    }

    @Override
    public Maybe<Long> insert(InvocationsStatistic invocationsStatistic) {
        return Maybe.fromCallable(() -> invocationsStatisticDao.insert(invocationsStatistic));
    }
}

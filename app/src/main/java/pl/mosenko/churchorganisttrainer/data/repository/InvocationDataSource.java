package pl.mosenko.churchorganisttrainer.data.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.dao.InvocationDao;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;

/**
 * Created by syk on 21.11.17.
 */

public class InvocationDataSource implements InvocationRepository {

    private InvocationDao invocationDao;

    @Inject
    public InvocationDataSource(InvocationDao invocationDao) {
        this.invocationDao = invocationDao;
    }

    @Override
    public Maybe<List<Invocation>> getInvocations() {
        return invocationDao.getInvocations();
    }

    @Override
    public Maybe<Invocation> getInvocationById(int invocationId) {
        return invocationDao.getInvocationById(invocationId);
    }

    @Override
    public Maybe<Long> insert(Invocation invocation) {
        return Maybe.fromCallable(() -> invocationDao.insert(invocation));
    }

    @Override
    public Maybe<Integer> delete(Invocation invocation) {
        return Maybe.fromCallable(() -> invocationDao.delete(invocation));
    }

    @Override
    public Maybe<List<Long>> insertAll(List<Invocation> invocations) {
        return Maybe.fromCallable(() -> invocationDao.insertAll(invocations));
    }
}

package pl.mosenko.churchorganisttrainer.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationRepository;

/**
 * Created by syk on 21.11.17.
 */

public class GetInvocations extends UseCase<GetInvocations.RequestValues, GetInvocations.ResponseValues> {

    private InvocationRepository invocationRepository;

    @Inject
    public GetInvocations(InvocationRepository invocationRepository) {
        this.invocationRepository = invocationRepository;
    }

    @Override
    protected Observable<ResponseValues> buildUserCaseObservable(RequestValues requestValues) {
        return invocationRepository.getInvocations()
                .map(ResponseValues::new)
                .toObservable();
    }

    public static class RequestValues implements UseCase.RequestValues {
    }

    public static class ResponseValues implements UseCase.ResponseValues {
        private final List<Invocation> invocations;

        public ResponseValues(List<Invocation> invocations) {
            this.invocations = invocations;
        }

        public List<Invocation> getInvocations() {
            return invocations;
        }
    }
}

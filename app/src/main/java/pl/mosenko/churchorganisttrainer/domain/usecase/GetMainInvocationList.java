package pl.mosenko.churchorganisttrainer.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationRepository;
import pl.mosenko.churchorganisttrainer.data.repository.InvocationStatisticRepository;
import pl.mosenko.churchorganisttrainer.domain.services.InvocationMainMapper;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationModel;

/**
 * Created by syk on 21.11.17.
 */

public class GetMainInvocationList extends UseCase<GetMainInvocationList.RequestValues, GetMainInvocationList.ResponseValues> {

    private InvocationRepository invocationRepository;
    private InvocationStatisticRepository statisticRepository;
    private InvocationMainMapper invocationMainMapper;

    @Inject
    public GetMainInvocationList(InvocationRepository invocationRepository, InvocationStatisticRepository statisticRepository, InvocationMainMapper invocationMainMapper) {
        this.invocationRepository = invocationRepository;
        this.statisticRepository = statisticRepository;
        this.invocationMainMapper = invocationMainMapper;
    }

    @Override
    protected Observable<ResponseValues> buildUserCaseObservable(RequestValues requestValues) {
        return invocationRepository.getInvocations()
                .flattenAsObservable(invocations -> invocations)
                .flatMap(invocation -> statisticRepository.getLastInvocationsStatisticForInvocation(invocation.getId())
                        .flatMap(invocationsStatistic -> invocationMainMapper.map(invocation, invocationsStatistic))
                        .toObservable())
                .toList()
                .map(ResponseValues::new)
                .toObservable();
    }

    public static class RequestValues implements UseCase.RequestValues {
    }

    public static class ResponseValues implements UseCase.ResponseValues {
        private final List<InvocationModel> invocationModels;

        public ResponseValues(List<InvocationModel> invocationModels) {
            this.invocationModels = invocationModels;
        }

        public List<InvocationModel> getInvocationModels() {
            return invocationModels;
        }
    }
}

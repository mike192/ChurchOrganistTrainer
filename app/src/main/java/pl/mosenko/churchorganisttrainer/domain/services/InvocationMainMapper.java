package pl.mosenko.churchorganisttrainer.domain.services;

import io.reactivex.Maybe;
import pl.mosenko.churchorganisttrainer.data.entities.Invocation;
import pl.mosenko.churchorganisttrainer.data.entities.InvocationsStatistic;
import pl.mosenko.churchorganisttrainer.presentation.invocation.InvocationModel;

/**
 * Created by syk on 16.12.17.
 */

public class InvocationMainMapper {

    public Maybe<InvocationModel> map(Invocation invocation, InvocationsStatistic invocationsStatistic) {
        return Maybe.fromCallable(() -> {
            String percentageResult = "-";
            if (invocationsStatistic != null && invocationsStatistic.getPercentageResult() != null) {
                percentageResult = String.format("%.2f", invocationsStatistic.getPercentageResult());
            }
            return new InvocationModel(invocation.getId(), invocation.getInvocationName(), percentageResult);
        });
    }
}

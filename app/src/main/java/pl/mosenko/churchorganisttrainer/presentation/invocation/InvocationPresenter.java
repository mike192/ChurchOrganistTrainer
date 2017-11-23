package pl.mosenko.churchorganisttrainer.presentation.invocation;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.domain.GetInvocations;
import pl.mosenko.churchorganisttrainer.presentation.common.presenter.BasePresenter;

/**
 * Created by syk on 16.10.17.
 */

@PerFragment
public class InvocationPresenter extends BasePresenter<InvocationContract.View>
        implements InvocationContract.Presenter {

    private GetInvocations getInvocations;

    @Inject
    public InvocationPresenter(InvocationContract.View view, GetInvocations getInvocations) {
        super(view);
        this.getInvocations = getInvocations;
    }
}

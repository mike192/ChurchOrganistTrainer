package pl.mosenko.churchorganisttrainer.presentation.invocation;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.data.repository.ToneRepository;

/**
 * Created by syk on 16.10.17.
 */

public class InvocationPresenter implements InvocationContract.Presenter {
    private InvocationContract.View invocationView;

    @Inject
    public InvocationPresenter(InvocationContract.View invocationView) {
        this.invocationView = invocationView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

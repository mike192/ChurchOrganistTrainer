package pl.mosenko.churchorganisttrainer.presentation.invocation;

/**
 * Created by syk on 16.10.17.
 */

public class InvocationPresenter implements InvocationContract.Presenter {
    private InvocationContract.View invocationView;

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

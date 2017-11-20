package pl.mosenko.churchorganisttrainer.presentation.invocation;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.presentation.common.presenter.BasePresenter;
import pl.mosenko.churchorganisttrainer.utils.SingletonUtil;

/**
 * Created by syk on 16.10.17.
 */

@PerFragment
public class InvocationPresenter extends BasePresenter<InvocationContract.View>
        implements InvocationContract.Presenter {

    @Inject
    public InvocationPresenter(InvocationContract.View view) {
        super(view);
    }
}

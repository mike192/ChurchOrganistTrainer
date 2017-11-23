package pl.mosenko.churchorganisttrainer.presentation.invocation;

import pl.mosenko.churchorganisttrainer.presentation.common.presenter.MVPPresenter;
import pl.mosenko.churchorganisttrainer.presentation.common.view.MVPView;

/**
 * Created by syk on 16.10.17.
 */

public interface InvocationContract {

    interface View extends MVPView {

        void hideProgressBar();
    }

    interface Presenter extends MVPPresenter {

        void getInvocations();
    }

}

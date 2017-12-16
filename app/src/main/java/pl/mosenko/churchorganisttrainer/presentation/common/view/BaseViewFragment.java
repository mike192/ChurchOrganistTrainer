package pl.mosenko.churchorganisttrainer.presentation.common.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.presentation.common.presenter.MVPPresenter;

/**
 * Created by syk on 20.11.17.
 */

public abstract class BaseViewFragment<T extends MVPPresenter> extends BaseFragment
        implements MVPView {

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        super.onDestroyView();
    }
}

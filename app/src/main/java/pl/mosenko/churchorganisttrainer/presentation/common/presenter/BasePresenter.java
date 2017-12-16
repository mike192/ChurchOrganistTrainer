package pl.mosenko.churchorganisttrainer.presentation.common.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pl.mosenko.churchorganisttrainer.presentation.common.view.MVPView;

/**
 * Created by syk on 12.10.17.
 */

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter {

    protected final V view;

    protected BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onDestroy() {
    }
}

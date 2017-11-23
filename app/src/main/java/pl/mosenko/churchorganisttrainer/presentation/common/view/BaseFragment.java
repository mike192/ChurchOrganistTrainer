package pl.mosenko.churchorganisttrainer.presentation.common.view;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

import static pl.mosenko.churchorganisttrainer.presentation.common.view.BaseActivityModule.ACTIVITY_CONTEXT;

/**
 * Created by syk on 20.11.17.
 */

public abstract class BaseFragment extends Fragment implements HasSupportFragmentInjector {

    @Inject
    @Named(ACTIVITY_CONTEXT)
    protected Context activityContext;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }
}
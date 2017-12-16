package pl.mosenko.churchorganisttrainer.presentation.invocation;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.domain.usecase.GetMainInvocationList;
import pl.mosenko.churchorganisttrainer.domain.usecase.UseCase;
import pl.mosenko.churchorganisttrainer.presentation.common.presenter.BasePresenter;
import timber.log.Timber;

/**
 * Created by syk on 16.10.17.
 */

@PerFragment
public class InvocationPresenter extends BasePresenter<InvocationContract.View>
        implements InvocationContract.Presenter {

    private GetMainInvocationList getMainInvocationList;

    @Inject
    public InvocationPresenter(InvocationContract.View view, GetMainInvocationList getMainInvocationList) {
        super(view);
        this.getMainInvocationList = getMainInvocationList;
    }

    @Override
    public void getInvocations() {
        view.hideProgressBar();
        getMainInvocationList.execute(new UseCase.UseCaseCallback<GetMainInvocationList.ResponseValues>() {
            @Override
            public void onSuccess(GetMainInvocationList.ResponseValues response) {
                view.showInvocationList(response.getInvocationModels());
            }

            @Override
            public void onError(Throwable e) {
                //todo generic error handling
                e.printStackTrace();
                Timber.e("NIE UDALO SIE");
            }
        }, new GetMainInvocationList.RequestValues());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMainInvocationList.dispose();
    }
}

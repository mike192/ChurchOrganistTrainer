package pl.mosenko.churchorganisttrainer.presentation.invocation;

import javax.inject.Inject;

import pl.mosenko.churchorganisttrainer.di.annotations.PerFragment;
import pl.mosenko.churchorganisttrainer.domain.usecase.GetInvocations;
import pl.mosenko.churchorganisttrainer.domain.usecase.UseCase;
import pl.mosenko.churchorganisttrainer.presentation.common.presenter.BasePresenter;
import timber.log.Timber;

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

    @Override
    public void getInvocations() {
        view.hideProgressBar();
        getInvocations.execute(new UseCase.UseCaseCallback<GetInvocations.ResponseValues>() {
            @Override
            public void onSuccess(GetInvocations.ResponseValues response) {
                Timber.e("UDALO SIE");
            }

            @Override
            public void onError(Throwable e) {
                //todo generic error handling
                e.printStackTrace();
                Timber.e("NIE UDALO SIE");
            }
        }, new GetInvocations.RequestValues());
    }
}

package pl.mosenko.churchorganisttrainer.domain.usecase;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by syk on 14.10.17.
 */

public abstract class UseCase<T extends UseCase.RequestValues, U extends UseCase.ResponseValues> {

    private final CompositeDisposable compositeDisposables;

    protected UseCase() {
        compositeDisposables = new CompositeDisposable();
    }

    protected abstract Observable<U> buildUserCaseObservable(T requestValues);

    public void execute(UseCaseCallback<U> callback, T requestValues) {
        checkNotNull(callback, "Callback cannot be null");
        final Observable<U> observable = buildUserCaseObservable(requestValues);
        Disposable disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError, callback::onComplete);
        addDisposable(disposable);
    }

    public void dispose() {
        if (!compositeDisposables.isDisposed()) {
            compositeDisposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        checkNotNull(disposable, "Disposable cannot be null");
        compositeDisposables.add(disposable);
    }

    public interface RequestValues {
    }

    public interface ResponseValues {
    }

    public interface UseCaseCallback<V extends UseCase.ResponseValues> {
        void onSuccess(V response);

        void onError(Throwable e);

        default void onComplete() {};
    }
}

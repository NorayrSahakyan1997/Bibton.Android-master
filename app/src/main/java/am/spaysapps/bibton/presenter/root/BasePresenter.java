package am.spaysapps.bibton.presenter.root;

import android.content.Context;

import javax.inject.Inject;

import am.spaysapps.bibton.shared.helpers.SharedPreferencesHelper;
import am.spaysapps.bibton.shared.networking.NetworkError;
import am.spaysapps.bibton.view.activities.IBaseView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class BasePresenter<T extends IBaseView> {

    @Inject
    protected Context mContext;
    @Inject
    protected SharedPreferencesHelper mShared;
    private final CompositeDisposable mDisposables;
    protected T mView;

    protected BasePresenter(){
        mDisposables = new CompositeDisposable();
    }

    public void onViewCreated(T view) {
        mView = view;
    }

    public void stopSubscriptions() {
        mDisposables.dispose();
    }

    protected void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    protected void errorToast(Throwable throwable) {
        NetworkError networkError = new NetworkError(mContext, throwable);
        mView.onError(networkError.getAppErrorMessage());
    }

    protected void errorView(Throwable throwable) {
        NetworkError networkError = new NetworkError(mContext, throwable);
        if (networkError.isServerError())
            mView.showServerError();
        else if (networkError.isNetworkError())
            mView.showNetworkError();
        else if (networkError.getError() instanceof HttpException)
            mView.showServerError();
        else
            mView.showServerError();
    }
}
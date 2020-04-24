package am.spaysapps.bibton.shared.data.services.root;

import am.spaysapps.bibton.model.ResponseModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseService {

    protected <T> Flowable<ResponseModel<T>> request(Flowable<ResponseModel<T>> call) {
        return call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    protected Completable request(Completable call) {
        return call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
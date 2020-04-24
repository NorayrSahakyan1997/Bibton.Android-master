package am.spaysapps.bibton.presenter;

import javax.inject.Inject;

import am.spaysapps.bibton.model.ResponseModel;
import am.spaysapps.bibton.model.createAccountModel.CreateAccountModel;
import am.spaysapps.bibton.model.forgetPassCodeModel.ForgetPassCodeModel;
import am.spaysapps.bibton.presenter.root.BasePresenter;
import am.spaysapps.bibton.shared.data.services.AuthorizationService;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.forgetPassCodeFragment.IForgetPassCodeFragment;
import io.reactivex.disposables.Disposable;

public class ForgetPassCodePresenter extends BasePresenter<IForgetPassCodeFragment> {
    private final AuthorizationService mService;


    @Inject
    ForgetPassCodePresenter(AuthorizationService service) {
        mService = service;
    }

    public void forgetPassCodeResponse(String unique_id,String passCode){

        Disposable disposable = mService.forgetPass(unique_id, passCode)
                .subscribe(this::forgetPassCode, this::errorView);
        addDisposable(disposable);
    }

    private void forgetPassCode(ResponseModel<ForgetPassCodeModel> forgetPassCodeModel) {
        mView.getToken(forgetPassCodeModel.getData().getToken());

    }

}

package am.spaysapps.bibton.presenter;

import android.widget.Toast;

import javax.inject.Inject;

import am.spaysapps.bibton.model.ResponseModel;
import am.spaysapps.bibton.model.getTransactionList.TransactionFilterRequestModel;
import am.spaysapps.bibton.model.getTransactionList.TransactionParentModel;
import am.spaysapps.bibton.presenter.root.BasePresenter;
import am.spaysapps.bibton.shared.data.services.AuthorizationService;
import am.spaysapps.bibton.view.activities.homeActivity.homeFragments.statementFragment.IStatementFragment;
import io.reactivex.disposables.Disposable;

public class StatementFragmentPresenter extends BasePresenter<IStatementFragment> {

    private final AuthorizationService mService;

    @Inject
    StatementFragmentPresenter(AuthorizationService service) {
        mService = service;
    }

    public void getTransactionList(TransactionFilterRequestModel transactionFilterRequestModel) {
        Disposable disposable = mService.getTransactionFiltered(transactionFilterRequestModel)
                .subscribe(this::transactionResponseFiltered, this::errorView);
        addDisposable(disposable);
    }


    private void transactionResponseFiltered(ResponseModel<TransactionParentModel> responseModel) {
        if (responseModel.isSuccess() && responseModel.getData() != null) {
            //mView.getFilteredTransactionList(responseModel.getData().getData());
            Toast.makeText(mContext,responseModel.getData().getData().size()+"",Toast.LENGTH_SHORT).show();
        } else

            mView.showServerError();
    }

    public void getTransactionList() {
        Disposable disposable = mService.getTransactionsUnfiltered()
                .subscribe(this::transactionResponseList, this::errorView);
        addDisposable(disposable);
    }


    private void transactionResponseList(ResponseModel<TransactionParentModel> responseModel) {
        if (responseModel.isSuccess() && responseModel.getData() != null) {
            //mView.getTransactionList(responseModel.getData().getData());

        } else

            mView.showServerError();
    }

}

package am.spaysapps.bibton.view.activities.homeActivity.homeFragments.statementFragment;

import java.util.List;

import am.spaysapps.bibton.model.getTransactionList.TransactionResponse;
import am.spaysapps.bibton.view.activities.IBaseView;

public interface IStatementFragment extends IBaseView {
    void getFilteredTransactionList(List<TransactionResponse> transactionResponses);
    void getTransactionList(List<TransactionResponse> transactionResponses);
}

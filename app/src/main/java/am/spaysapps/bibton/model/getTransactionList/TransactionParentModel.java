package am.spaysapps.bibton.model.getTransactionList;

import java.util.List;

public class TransactionParentModel {
    private List<TransactionDateResponse> data;
    private int current_page;

    public List<TransactionDateResponse> getData() {
        return data;
    }
}

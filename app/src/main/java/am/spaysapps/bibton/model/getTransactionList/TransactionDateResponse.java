package am.spaysapps.bibton.model.getTransactionList;

import java.util.List;

public class TransactionDateResponse {
    private String date;
    private List<TransactionResponse> list;

    public List<TransactionResponse> getList() {
        return list;
    }

    public String getDate() {
        return date;
    }
}

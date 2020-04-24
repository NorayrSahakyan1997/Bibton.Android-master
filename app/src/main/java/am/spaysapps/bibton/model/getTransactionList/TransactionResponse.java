package am.spaysapps.bibton.model.getTransactionList;

public class TransactionResponse {
    private int transaction_number;
    private String text;
    private String image;
    private String created_at;
    private float total_amount;
    private int transfer_type;
    private int transaction_id;

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getTransfer_type() {
        return transfer_type;
    }

    public String getCreated_at() {

        return created_at;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public int getTransaction_number() {
        return transaction_number;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}

package am.spaysapps.bibton.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import am.spaysapps.bibton.R;
import am.spaysapps.bibton.model.getTransactionList.TransactionResponse;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatementFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TransactionResponse> transactionResponseList;
    private View view_statement_row;


    public StatementFragmentAdapter(Context context, List<TransactionResponse> transactionResponses) {
        this.context = context;
        this.transactionResponseList = transactionResponses;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view_statement_row = layoutInflater.inflate(R.layout.transaction_list_child_row, parent, false);
        RecyclerView.ViewHolder viewHolder = new StatementFragmentAdapter.ViewHolder(view_statement_row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StatementFragmentAdapter.ViewHolder statementFragmentViewHolder = (StatementFragmentAdapter.ViewHolder) holder;
        statementFragmentViewHolder.transaction_cost.setText(transactionResponseList.get(position).getTotal_amount() + "$");
        statementFragmentViewHolder.transaction_name.setText(transactionResponseList.get(position).getText());
        Picasso.get()
                .load(transactionResponseList.get(position).getImage())
                .into(statementFragmentViewHolder.transaction_image);
    }

    @Override
    public int getItemCount() {
        return transactionResponseList.size();
    }

    private  class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView transaction_image;
        private TextView transaction_name;
        private TextView transaction_cost;

        private  ViewHolder(@NonNull View itemView) {
            super(itemView);
            transaction_image = itemView.findViewById(R.id.transaction_item_image);
            transaction_name = itemView.findViewById(R.id.transaction_name);
            transaction_cost = itemView.findViewById(R.id.transaction_cost);

        }
    }
}

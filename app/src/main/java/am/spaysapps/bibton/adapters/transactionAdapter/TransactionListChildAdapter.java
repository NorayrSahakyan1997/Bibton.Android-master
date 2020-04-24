package am.spaysapps.bibton.adapters.transactionAdapter;

import android.annotation.SuppressLint;
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

public class TransactionListChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TransactionResponse> transactionResponses;
    private View mainView;
    private final TransactionListChildAdapter.OnItemClickListener mListener;



    public TransactionListChildAdapter(Context context, List<TransactionResponse> transactionResponses,TransactionListChildAdapter.OnItemClickListener mListener) {
        this.context = context;
        this.transactionResponses=transactionResponses;
        this.mListener=mListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //mainView = layoutInflater.inflate(R.layout.transaction_list_child_row, parent, false);
        @SuppressLint("InflateParams") View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_child_row, null);
        mainView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        RecyclerView.ViewHolder viewHolder = new TransactionListChildAdapter.ViewHolder(mainView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TransactionListChildAdapter.ViewHolder viewHolder = (TransactionListChildAdapter.ViewHolder) holder;
        viewHolder.transaction_name.setText(transactionResponses.get(position).getText());
        viewHolder.transaction_cost.setText(transactionResponses.get(position).getTotal_amount()+"$");
        Picasso.get()
                .load(transactionResponses.get(position).getImage())
                .into(viewHolder.transaction_image);
        viewHolder.onClick(holder.itemView, position);


    }

    @Override
    public int getItemCount() {
        return transactionResponses.size();
    }

    public interface OnItemClickListener {
        void onClick(final int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView transaction_image;
        TextView transaction_name;
        TextView transaction_cost;

        ViewHolder(View itemView) {
            super(itemView);
            transaction_image = itemView.findViewById(R.id.transaction_item_image);
            transaction_name = itemView.findViewById(R.id.transaction_name);
            transaction_cost = itemView.findViewById(R.id.transaction_cost);
        }
        void onClick(final View itemView, final int position) {
            itemView.setOnClickListener(v -> mListener.onClick(position));
        }

    }
}

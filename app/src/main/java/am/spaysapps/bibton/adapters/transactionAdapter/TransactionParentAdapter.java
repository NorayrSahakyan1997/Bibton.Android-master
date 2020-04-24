package am.spaysapps.bibton.adapters.transactionAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import am.spaysapps.bibton.R;
import am.spaysapps.bibton.model.getTransactionList.TransactionDateResponse;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private View mainView;
    private RecyclerView recycler_item_2;
    private List<TransactionDateResponse> date;



    public TransactionParentAdapter(Context context,List<TransactionDateResponse> date){
        this.context=context;
        this.date=date;
        layoutInflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View mainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_parent_row, null);
        mainView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        RecyclerView.ViewHolder viewHolder= new TransactionParentAdapter.ViewHolder(mainView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TransactionParentAdapter.ViewHolder viewHolder = (TransactionParentAdapter.ViewHolder) holder;
        viewHolder.textView_Parent_Date.setText(date.get(position).getDate());
        TransactionListChildAdapter transactionListAdapter= new TransactionListChildAdapter(context, date.get(position).getList(), (position1 ) -> Toast.makeText(context, date.get(position).getList().get(position).getTransaction_id()+"",Toast.LENGTH_SHORT).show());
        viewHolder.recycler_child_view.setLayoutManager(new LinearLayoutManager(context));
        viewHolder.recycler_child_view.setAdapter(transactionListAdapter);
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_Parent_Date;
        RecyclerView recycler_child_view;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_Parent_Date=(TextView)itemView.findViewById(R.id.text_date_transaction);
            recycler_child_view=(RecyclerView)itemView.findViewById(R.id.recycler_transaction_parent);
        }
    }
}

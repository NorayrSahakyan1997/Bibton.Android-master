package am.spaysapps.bibton.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import am.spaysapps.bibton.R;
import am.spaysapps.bibton.model.walletCurrency.WalletCurrencyResponse;
import am.spaysapps.bibton.shared.utils.Constants;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment.PhoneNumberFragment;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class BalanceHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<WalletCurrencyResponse> walletCurrencyResponses;
    private View mainView;
    private ConstraintLayout constraintLayout_wallet;
    private TextView currencyName;
    private Fragment current_Fragment;



    public BalanceHomeAdapter(Context context, List<WalletCurrencyResponse> walletCurrencyResponses,Fragment current_Fragment,ConstraintLayout constraintLayout_wallet,TextView currencyName) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.current_Fragment=current_Fragment;
        this.walletCurrencyResponses = walletCurrencyResponses;
        this.constraintLayout_wallet=constraintLayout_wallet;
        this.currencyName=currencyName;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mainView = layoutInflater.inflate(R.layout.recycler_balance_row, parent, false);
        RecyclerView.ViewHolder viewHolder = new BalanceHomeAdapter.ViewHolder(mainView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BalanceHomeAdapter.ViewHolder viewHolder = (BalanceHomeAdapter.ViewHolder) holder;
        viewHolder.country_name.setText(walletCurrencyResponses.get(position).getCurrency_name());
        viewHolder.county_money_short_name.setText(walletCurrencyResponses.get(position).getCurrency_iso());
        viewHolder.currency_amount.setText(walletCurrencyResponses.get(position).getBalance() + walletCurrencyResponses.get(position).getSymbol());
        Picasso.get()
                .load(walletCurrencyResponses.get(position).getCurrency_icon())
                .into(viewHolder.country_flags);
    }

    @Override
    public int getItemCount() {
        return walletCurrencyResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView county_money_short_name;
        ImageView country_flags;
        TextView country_name;
        TextView currency_amount;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            county_money_short_name = itemView.findViewById(R.id.county_money_short_name);
            country_flags = itemView.findViewById(R.id.country_flag_balance);
            country_name = itemView.findViewById(R.id.country_name_balance_list);
            currency_amount = itemView.findViewById(R.id.currency_amount);
        }

        @Override
        public void onClick(View v) {

            constraintLayout_wallet.setVisibility(View.INVISIBLE);
            currencyName.setText(walletCurrencyResponses.get(getAdapterPosition()).getCurrency_iso());
            FragmentTransaction ft = ((FragmentActivity) mainView.getContext()).getSupportFragmentManager().beginTransaction();
            Constants.CURRENCY_ID=getAdapterPosition();
            ft.detach(current_Fragment).attach(current_Fragment).commit();

//            ft.detach(current_Fragment);
//            ft.attach(current_Fragment);
//            ft.commit();


        }
    }
}

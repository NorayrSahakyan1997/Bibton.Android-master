package am.spaysapps.bibton.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import am.spaysapps.bibton.R;
import am.spaysapps.bibton.model.countryModel.CountryModel;
import am.spaysapps.bibton.shared.utils.Constants;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment.PhoneNumberFragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CountryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerView.OnItemTouchListener {

    private Context context;
    private List<CountryModel> countryArray;
    private LayoutInflater layoutInflater;
    private String selected_Country_Code;
    private View view;



    public CountryListAdapter(Context context, List<CountryModel> countryArray) {
        this.countryArray = countryArray;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.search_view_child, parent, false);
        RecyclerView.ViewHolder viewHolder = new CountryListAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CountryListAdapter.ViewHolder viewHolder = (CountryListAdapter.ViewHolder) holder;
        viewHolder.country_names.setText(countryArray.get(position).getName());
        viewHolder.country_code.setText(countryArray.get(position).getPhone_code() + "");
        Picasso.get()
                .load(countryArray.get(position).getFlag())
                //.error(R.drawable.user_placeholder_error)
                .into(viewHolder.country_flags);

    }


    @Override
    public int getItemCount() {
        return countryArray.size();
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        return false;
    }


    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView country_names;
        ImageView country_flags;
        TextView country_code;

        ViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            country_names = itemView.findViewById(R.id.country_names);
            country_flags = itemView.findViewById(R.id.country_flags);
            country_code = itemView.findViewById(R.id.country_code);
        }

        @Override
        public void onClick(View v) {
            Fragment newFragment = new PhoneNumberFragment();
            FragmentTransaction transaction = ((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayoutWelcome, newFragment);
            Constants.COUNTRY_CODE = countryArray.get(getAdapterPosition()).getPhone_code();
            Constants.COUNTRY_SHORT_NAME = countryArray.get(getAdapterPosition()).getShort_name();
            transaction.commit();
        }

    }
}


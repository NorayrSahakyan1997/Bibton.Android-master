package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.countrySearchFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import am.spaysapps.bibton.Bibton;
import am.spaysapps.bibton.R;
import am.spaysapps.bibton.adapters.CountryListAdapter;
import am.spaysapps.bibton.model.countryModel.CountryModel;
import am.spaysapps.bibton.presenter.CountrySearchPresenter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CountrySearchFragment extends Fragment implements ICountrySearchFragment {
    private View mainView;
    private RecyclerView recycler_view_country_flags;
    private SearchView search_view_countries;
    @Inject
    CountrySearchPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.country_search_fragment, container, false);
        Bibton.getInstance().getAuthorizationComponent().inject(this);
        mPresenter.onViewCreated(this);
        mPresenter.getCountryList();
        init();
        return mainView;
    }

    private void init() {
        recycler_view_country_flags = mainView.findViewById(R.id.recycler_view_country_flags);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_view_country_flags.setLayoutManager(layoutManager);
        search_view_countries = mainView.findViewById(R.id.search_view_countries);
        search_view_countries.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchItemsFromCountryList(search_view_countries.getQuery().toString());

                return false;
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Bibton.getInstance().releaseAuthorizationComponent();
        mPresenter.stopSubscriptions();

    }


    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void showServerError() {

    }

    @Override
    public void showNetworkError() {

    }

    private List<CountryModel> outputCountries;

    @Override
    public void showCountryList(List<CountryModel> list) {
        outputCountries = new ArrayList<>();
        outputCountries = list;
        CountryListAdapter countryListAdapter = new CountryListAdapter(getContext(), outputCountries);
        recycler_view_country_flags.setAdapter(countryListAdapter);

    }


    private void searchItemsFromCountryList(String query) {
        List<CountryModel> filteredList = new ArrayList<>();

        if (search_view_countries != null) {
            for (CountryModel item : outputCountries) {
                if (item.getName().toLowerCase().startsWith(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }

        } else
            filteredList = outputCountries;
        CountryListAdapter countryListAdapter = new CountryListAdapter(getContext(), filteredList);
        recycler_view_country_flags.setAdapter(countryListAdapter);
    }

}

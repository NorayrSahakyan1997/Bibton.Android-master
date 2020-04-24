package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.countrySearchFragment;

import java.util.List;

import am.spaysapps.bibton.model.countryModel.CountryModel;
import am.spaysapps.bibton.view.activities.IBaseView;

public interface ICountrySearchFragment extends IBaseView {
    void showCountryList(List<CountryModel> list);

}

package am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment;



import am.spaysapps.bibton.view.activities.IBaseView;

public interface IPhoneNumberFragment extends IBaseView {
    //void showBalanceList(List<CountryModel> list);
    void showCountryCode(String countryCode);
    void checkPhoneNumberValidation(Boolean message);
    void showUniqueID(String uniqueId);
}

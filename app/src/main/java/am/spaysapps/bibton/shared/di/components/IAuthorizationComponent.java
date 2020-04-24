package am.spaysapps.bibton.shared.di.components;

import am.spaysapps.bibton.shared.di.components.root.IAppComponent;
import am.spaysapps.bibton.shared.di.modules.AuthorizationModule;
import am.spaysapps.bibton.shared.di.scopes.AuthorizationScope;
import am.spaysapps.bibton.view.activities.homeActivity.homeFragments.statementFragment.StatementFragment;
import am.spaysapps.bibton.view.activities.homeActivity.homeFragments.homeFragment.HomeFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.forgetPassCodeFragment.ForgetPassCodeFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.countrySearchFragment.CountrySearchFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.createPassCodeFragment.CreatePassCodeFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.inputCodeFragment.InputPhoneCodeFragment;
import am.spaysapps.bibton.view.activities.welcomeActivity.welcomeFragments.phoneNumberFragment.PhoneNumberFragment;
import dagger.Component;

@AuthorizationScope
@Component(dependencies = {IAppComponent.class}, modules = {AuthorizationModule.class})
public interface IAuthorizationComponent {
    void inject(PhoneNumberFragment fragment);

    void inject(CountrySearchFragment countrySearchFragment);

    void inject(InputPhoneCodeFragment inputPhoneCodeFragment);

    void inject (CreatePassCodeFragment createPassCodeFragment);

    void inject (ForgetPassCodeFragment forgetPassCodeFragment);

    void inject(HomeFragment homeFragment);

    void inject(StatementFragment statementFragment);


}
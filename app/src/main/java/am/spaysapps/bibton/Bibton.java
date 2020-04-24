package am.spaysapps.bibton;

import android.app.Application;
import android.content.Context;

import am.spaysapps.bibton.shared.di.components.DaggerIAuthorizationComponent;
import am.spaysapps.bibton.shared.di.components.IAuthorizationComponent;
import am.spaysapps.bibton.shared.di.components.root.DaggerIAppComponent;
import am.spaysapps.bibton.shared.di.components.root.IAppComponent;
import am.spaysapps.bibton.shared.di.modules.AuthorizationModule;
import am.spaysapps.bibton.shared.di.modules.root.AppModule;
import am.spaysapps.bibton.shared.di.modules.root.NetModule;
import androidx.multidex.MultiDex;

public class Bibton extends Application {

    private static Bibton mInstance;
    private IAppComponent mIAppComponent;
    private IAuthorizationComponent mIAuthorizationComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

/*        List<Locale> supportedLocales = new ArrayList<>();
        supportedLocales.add(new Locale(getResources().getString(R.string.armenian_lang_code), getResources().getString(R.string.armenian_lang_country)));
        supportedLocales.add(new Locale(getResources().getString(R.string.english_lang_code), getResources().getString(R.string.english_lang_country)));
        supportedLocales.add(new Locale(getResources().getString(R.string.russian_lang_code), getResources().getString(R.string.russian_lang_country)));
        LocaleChanger.initialize(getApplicationContext(), supportedLocales);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = settings.getString(getString(R.string.locale_lang), getResources().getString(R.string.armenian_lang_code));
        changeLang(lang);*/

        mIAppComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public static synchronized Bibton getInstance() {
        return mInstance;
    }

    public void changeLang(String lang) {
       /* SharedPreferences.Editor ed = PreferenceManager.getDefaultSharedPreferences(this).edit();
        ed.putString(getString(R.string.locale_lang), lang);
        ed.apply();

        String country = getResources().getString(R.string.armenian_lang_country);

        if (lang.equals(getResources().getString(R.string.armenian_lang_code))) {
            country = getResources().getString(R.string.armenian_lang_country);
        } else if (lang.equals(getResources().getString(R.string.english_lang_code))) {
            country = getResources().getString(R.string.english_lang_country);
        } else if (lang.equals(getResources().getString(R.string.russian_lang_code))) {
            country = getResources().getString(R.string.russian_lang_country);
        }

        LocaleChanger.setLocale(new Locale(lang, country));*/
    }

    public String getLang() {
        //return PreferenceManager.getDefaultSharedPreferences(this).getString(this.getString(R.string.locale_lang), getResources().getString(R.string.armenian_lang_code));
        return "";
    }

    public IAuthorizationComponent getAuthorizationComponent() {
        mIAuthorizationComponent = DaggerIAuthorizationComponent.builder()
                .iAppComponent(mIAppComponent)
                .authorizationModule(new AuthorizationModule())
                .build();
        return mIAuthorizationComponent;
    }

    public void releaseAuthorizationComponent() {
        mIAuthorizationComponent = null;
    }
}
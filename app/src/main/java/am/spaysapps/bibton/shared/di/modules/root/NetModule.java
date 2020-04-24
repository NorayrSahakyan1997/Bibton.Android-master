package am.spaysapps.bibton.shared.di.modules.root;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import am.spaysapps.bibton.BuildConfig;
import am.spaysapps.bibton.shared.helpers.SharedPreferencesHelper;
import am.spaysapps.bibton.shared.utils.Constants;
import am.spaysapps.bibton.shared.utils.NetworkStatusUtils;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class NetModule {

    private final int mMaxStale = 60 * 60 * 24 * 5; // 5-days

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, Application application) {
        final SharedPreferencesHelper shared = new SharedPreferencesHelper(application);

        return new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();
            // Customize the request
            Request request = original.newBuilder()
                    .header("Content-Type", "application/json")
                  //  .header("Authorization", "Bearer " + shared.getStringSharedPreferences(Constants.TOKEN))
                    .header("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImFlMjk5NzcxZTgyMzI2YTEzZDdiMGVkMjcyMTZhOTcxNDhkNWViNDgyMDBmMmFlYjg0YzBjMmQxZjg5MjEzMTFkOTBhMGU4NDI1MjYxNmQ0In0.eyJhdWQiOiI1IiwianRpIjoiYWUyOTk3NzFlODIzMjZhMTNkN2IwZWQyNzIxNmE5NzE0OGQ1ZWI0ODIwMGYyYWViODRjMGMyZDFmODkyMTMxMWQ5MGEwZTg0MjUyNjE2ZDQiLCJpYXQiOjE1NDkzNzQ0OTAsIm5iZiI6MTU0OTM3NDQ5MCwiZXhwIjoxNTgwOTEwNDkwLCJzdWIiOiI5NSIsInNjb3BlcyI6W119.N2jwTD-LLEMOEZO3PAWueZ4AFKOW0eHfTiD4uP4UgpmE5tTvSBbV6yFGoH-DOgy4HtkvPiL-1-3xEj-EHmaRGlJnaCW6RGQtV72xhTmGWzhtGxKSiP81fp9Woc0OYRxbfW7DMnVCS5F4x03gYsT0laYzeKes-9SaXOf77XK3aYLes5dYnlxM1lTXADWA9dmK_WKoFjWnvmaweoJjaW_LX9IN53wqo6Ae2OyA6G3Yk7sPliPolES801fU69F3aJD_ROuniJv17tWDwnjfUAcjZ7emZKvNhgup19AyIFF-NR6ZP2Xetx_Lv9GnMz4Kga20XmUJkdU8CYAiYRx2gICdJ-Y6XR33g9hDISbJdRvLE0qjYbyVNptbYwBK-AbvalcBKrDrfABmgC9_GqGksq4jtpd02zMKt2jLx5W4_pCeHkTyl4iSfjXKV5ewmY3cibsJ6MHvVLteUj5sbf-rFOFr3llpTAANPskLRSkcC-YRD1WnHCrvaUGdKn5ziF7LB9tTynUpOrOAN5Gi8Le0IX9gNz9afuqUQbWi6x6DHspMFhTyeYwHNr-fOvlAmg3vdI446Pk8ZI_jslg-_kzbxao8K7KzAaqQ4BrY8pYPdWZzQW4Yf7JZCsNK-C6scIyxaKPA9O20FI1iUKPbvCCe6u5eyDvEYe_1zkUCottoE67Qb5Y")
                    .header("OsType", "1")
                    .header("Cache-Control", (NetworkStatusUtils.isNetworkAvailable(application)) ?
                            "public, max-age=" + mMaxStale : "public, max-stale=" + mMaxStale)
                    .build();
            okhttp3.Response response = chain.proceed(request);
            response.cacheResponse();
            // Customize or return the response
            return response;
        })
                .cache(cache)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
package ru.innopolis.yorsogettingxbox.network;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.innopolis.yorsogettingxbox.BuildConfig;

public class ApiFactory {

    private static OkHttpClient sClient;

    private static volatile DocumentsApi sDocumentsService;
    private static volatile DealsApi sDealsService;

    private ApiFactory() {
    }

    @NonNull
    public static DocumentsApi getDocumentsApiService() {
        DocumentsApi service = sDocumentsService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sDocumentsService;
                if (service == null) {
                    service = sDocumentsService = buildRetrofit().create(DocumentsApi.class);
                }
            }
        }
        return service;
    }

    @NonNull
    public static DealsApi getDealsApiService() {
        DealsApi service = sDealsService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sDealsService;
                if (service == null) {
                    service = sDealsService = buildRetrofit().create(DealsApi.class);
                }
            }
        }
        return service;
    }

    public static void recreate() {
        sClient = null;
        sClient = getClient();
        sDocumentsService = buildRetrofit().create(DocumentsApi.class);
        sDealsService = buildRetrofit().create(DealsApi.class);
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }
}

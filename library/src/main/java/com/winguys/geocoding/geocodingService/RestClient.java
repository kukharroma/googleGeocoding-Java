package com.winguys.geocoding.geocodingService;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Stafiiyevskyi on 18.01.2016.
 */
public class RestClient {

    private static final String BASE_URL = "https://maps.google.com/maps/api/geocode/";
    private static RestClient instance = null;
    private GeocodeService service;
    private OkHttpClient client;
    private String apiKey = "Service key"; //in future must be added by user

    private RestClient() {
        client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("key",apiKey)
                        .build();
                return chain.proceed(request);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build();
        service = retrofit.create(GeocodeService.class);
    }

    public GeocodeService getGeocodeService() {
        return service;
    }

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }
}


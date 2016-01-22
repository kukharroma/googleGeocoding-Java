package com.winguys.geocoding.geocodingService;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.winguys.geocoding.constant.GeocodingUrl;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Stafiiyevskyi on 18.01.2016.
 */
public class RestClient {

    private static RestClient instance = null;
    private GeocodeService service;

    private RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GeocodingUrl.GEOCODING_API_URL)
                .build();
        service = retrofit.create(GeocodeService.class);
    }

    public GeocodeService getGeocodeService() {
        return service;
    }

    public static RestClient getInstance(String apiServiceKey) {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }
}


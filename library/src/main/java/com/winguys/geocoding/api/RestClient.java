package com.winguys.geocoding.api;

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
                .baseUrl(Url.BASE_URL)
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


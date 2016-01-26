package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.RestClient;
import com.winguys.geocoding.api.ReverseUrlBuilder;
import com.winguys.geocoding.model.GeocodeResult;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseGeocodingUseCase {

    public void execute(ReverseGeocoding reverseGeocoding, final OnGeocodingResultListener listener) {
        ReverseUrlBuilder urlBuilder = new ReverseUrlBuilder(reverseGeocoding);
        RestClient.getInstance().getGeocodeService().makeReverseGeocoding(urlBuilder.buildUrl()).enqueue(new Callback<GeocodeResult>() {
            @Override
            public void onResponse(Response<GeocodeResult> response, Retrofit retrofit) {
                if (listener != null)
                    listener.onGeocodingResultListener(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}

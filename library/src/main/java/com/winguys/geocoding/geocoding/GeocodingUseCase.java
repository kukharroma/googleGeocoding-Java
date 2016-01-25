package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.RestClient;
import com.winguys.geocoding.model.GeocodeResult;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by roma on 25.01.16.
 */
public class GeocodingUseCase {

    public void execute(Geocoding geocoding, final OnGeocodingResultListener listener) {
        UrlBuilder urlBuilder = new UrlBuilder(geocoding);
        RestClient.getInstance().getGeocodeService().makeGeocoding(urlBuilder.buildUrl()).enqueue(new Callback<GeocodeResult>() {
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

package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.RestClient;
import com.winguys.geocoding.api.mapBuilder.GeocodingMapBuilder;
import com.winguys.geocoding.model.GeocodeResult;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by roma on 25.01.16.
 */
public class GeocodingUseCase {

    public void execute(Geocoding geocoding, final OnGeocodingResultListener listener) {
        GeocodingMapBuilder geocodingMapBuilder = new GeocodingMapBuilder(geocoding);
        RestClient.getInstance().getGeocodeService().makeGeocoding(geocodingMapBuilder.buildUrl()).enqueue(new Callback<GeocodeResult>() {
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

package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.RestClient;
import com.winguys.geocoding.api.constant.RequestMessage;
import com.winguys.geocoding.api.mapBuilder.ReverseGeocodingMapBuilder;
import com.winguys.geocoding.model.GeocodeResult;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseGeocodingUseCase {

    public void execute(ReverseGeocoding reverseGeocoding, final OnGeocodingResultListener listener) {
        ReverseGeocodingMapBuilder urlBuilder = new ReverseGeocodingMapBuilder(reverseGeocoding);
        RestClient.getInstance().getGeocodeService().makeReverseGeocoding(urlBuilder.buildUrl()).enqueue(new Callback<GeocodeResult>() {
            @Override
            public void onResponse(Response<GeocodeResult> response, Retrofit retrofit) {
                if (listener != null)
                    if (response.body().getStatus().equals(RequestMessage.OK))
                        listener.onSuccess(response.body());
                    else
                        listener.onFailed(response.body().getStatus());
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}

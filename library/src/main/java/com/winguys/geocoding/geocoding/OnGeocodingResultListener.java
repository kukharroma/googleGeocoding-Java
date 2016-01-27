package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.model.GeocodeResult;

/**
 * Created by roma on 25.01.16.
 */
public interface OnGeocodingResultListener {

    void onSuccess(GeocodeResult geocodeResult);

    void onFailed(String message);
}

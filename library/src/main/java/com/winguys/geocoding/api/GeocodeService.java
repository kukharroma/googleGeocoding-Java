package com.winguys.geocoding.api;


import com.winguys.geocoding.constant.GeocodingUrl;
import com.winguys.geocoding.model.GeocodeResult;

import java.util.Map;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by Stafiiyevskyi on 18.01.2016.
 */
public interface GeocodeService {

    @GET(GeocodingUrl.JSON_PARAM)
    Call<GeocodeResult> getDataFromGeocodeService(@QueryMap Map<String, String> options);

}
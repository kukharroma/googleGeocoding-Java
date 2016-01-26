package com.winguys.geocoding.main;


import com.winguys.geocoding.api.constant.AddressType;
import com.winguys.geocoding.api.constant.Language;
import com.winguys.geocoding.api.constant.Region;
import com.winguys.geocoding.api.constant.ReverseLocationType;
import com.winguys.geocoding.geocoding.Geocoding;
import com.winguys.geocoding.geocoding.OnGeocodingResultListener;
import com.winguys.geocoding.geocoding.ReverseGeocoding;
import com.winguys.geocoding.model.GeocodeResult;

/**
 * Created by roma on 25.01.16.
 */
public class Main {

    public static void main(String[] args) {
        Geocoding geocoding = Geocoding.newBuilder().setAddress("address")
                .setComponents("qewrty", "123456", "adsfdsfasdf", "123540", Region.GREAT_BRITAIN_UK)
                .setBounds("34.172684,-118.604794", "34.236144,-118.500938")
                .setApiKey("56466488949").build();

        geocoding.execute(new OnGeocodingResultListener() {
            @Override
            public void onGeocodingResultListener(GeocodeResult geocodeResult) {

            }
        });

        ReverseGeocoding.newBuilder().setApiKey("adpaddpadpadd")
                .setLatLng("40.714224,-73.961452")
                .setLanguage(Language.ENGLISH)
                .setLocationTypes(ReverseLocationType.RANGE_INTERPOLATED, ReverseLocationType.GEOMETRIC_CENTER)
                .setResultTypes(AddressType.ADMINISTRATIVE_AREA_LEVEL_1,AddressType.COUNTRY,AddressType.ESTABLISHMENT)
                .build().execute(new OnGeocodingResultListener() {
            @Override
            public void onGeocodingResultListener(GeocodeResult geocodeResult) {

            }
        });

    }

}

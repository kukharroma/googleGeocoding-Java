package com.winguys.geocoding.main;


import com.winguys.geocoding.api.constant.AddressType;
import com.winguys.geocoding.api.constant.Language;
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
        Geocoding geocoding = Geocoding.newBuilder().setAddress("Vinnitsa,St.Kelecka")
                .setApiKey("AIzaSyBpprOpfgA6NOy5VYcIEGzA-g2oslXIcRY").build();

        geocoding.execute(new OnGeocodingResultListener() {
            @Override
            public void onGeocodingResultListener(GeocodeResult geocodeResult) {
                System.out.println("Status :" + geocodeResult.getStatus());
                System.out.println("Result(address) :" + geocodeResult.getResults().get(0).getFormattedAddress());
                System.out.println("Result(latLng) :" + geocodeResult.getResults().get(0).getGeometry().getLocation().getLat() + ", " + geocodeResult.getResults().get(0).getGeometry().getLocation().getLng());
            }
        });

        ReverseGeocoding.newBuilder().setApiKey("AIzaSyBpprOpfgA6NOy5VYcIEGzA-g2oslXIcRY")
                .setLatLng("40.714224,-73.961452")
                .setLanguage(Language.ENGLISH)
                .setResultTypes(AddressType.COUNTRY)
                .build().execute(new OnGeocodingResultListener() {
            @Override
            public void onGeocodingResultListener(GeocodeResult geocodeResult) {
                System.out.println("Status reverse:" + geocodeResult.getStatus());
                System.out.println("Result(address) :" + geocodeResult.getResults().get(0).getFormattedAddress());
                System.out.println("Result(latLng) :" + geocodeResult.getResults().get(0).getGeometry().getLocation().getLat() + ", " + geocodeResult.getResults().get(0).getGeometry().getLocation().getLng());
            }
        });

    }

}

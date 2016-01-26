package com.winguys.geocoding.api;

/**
 * Created by roma on 22.01.16.
 */
public interface Url {
    String BASE_URL = "https://maps.google.com/maps/api/geocode/";
    String JSON_TYPE = "json?";

    interface Geocoding {
        String ADDRESS = "address";
        String COMPONENTS = "components";
        String KEY = "key";
        String BOUNDS = "bounds";
        String LANGUAGE = "language";
        String REGION = "region";
    }

    interface Components {
        String ROUTE = "route";
        String LOCALITY = "locality";
        String ADMINISTRATIVE_AREA = "administrative_area";
        String POSTAL_CODE = "postal_code";
        String COUNTRY = "country";
    }

    interface ReverseGeocoding {
        String LAT_LNG = "latlng";
        String PLACE_ID = "place_id";
        String LOCATION_TYPE = "location_type";
        String RESULT_TYPE = "result_type";
    }

}

package com.winguys.geocoding.api.mapBuilder;

import com.winguys.geocoding.api.Url;
import com.winguys.geocoding.geocoding.ReverseGeocoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseGeocodingMapBuilder extends QueryMapBuilder {

    private ReverseGeocoding reverseGeocoding;

    public ReverseGeocodingMapBuilder(ReverseGeocoding geocoding) {
        this.reverseGeocoding = geocoding;
    }

    @Override
    public Map<String, String> buildUrl() {
        map = new HashMap<>();
        if (reverseGeocoding.getLatitude() != null & reverseGeocoding.getLongitude() != null) {
            map.put(Url.ReverseGeocoding.LAT_LNG, reverseGeocoding.getLatitude() + ", " + reverseGeocoding.getLongitude());
        } else {
            map.put(Url.ReverseGeocoding.PLACE_ID, reverseGeocoding.getPlaceId());
        }

        if (reverseGeocoding.getLocationTypes() != null) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < reverseGeocoding.getLocationTypes().length; i++) {
                value.append(reverseGeocoding.getLocationTypes()[i].getParam());
                if (i != reverseGeocoding.getLocationTypes().length - 1) {
                    value.append("|");
                }
            }
            map.put(Url.ReverseGeocoding.LOCATION_TYPE, value.toString());
        }

        if (reverseGeocoding.getResultTypes() != null) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < reverseGeocoding.getResultTypes().length; i++) {
                value.append(reverseGeocoding.getResultTypes()[i].getParam());
                if (i != reverseGeocoding.getResultTypes().length - 1) {
                    value.append("|");
                }
            }
            map.put(Url.ReverseGeocoding.RESULT_TYPE, value.toString());
        }

        if (reverseGeocoding.getLanguage() != null) {
            map.put(Url.Geocoding.LANGUAGE, reverseGeocoding.getLanguage().getParam());
        }

        map.put(Url.Geocoding.KEY, reverseGeocoding.getApiKey());

        return map;
    }
}

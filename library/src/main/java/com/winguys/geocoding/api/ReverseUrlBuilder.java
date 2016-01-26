package com.winguys.geocoding.api;

import com.winguys.geocoding.api.constant.AddressType;
import com.winguys.geocoding.api.constant.ReverseLocationType;
import com.winguys.geocoding.geocoding.ReverseGeocoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseUrlBuilder {
    private ReverseGeocoding reverseGeocoding;
    private Map<String, String> map;

    public ReverseUrlBuilder(ReverseGeocoding geocoding) {
        this.reverseGeocoding = geocoding;
    }

    public Map<String, String> buildUrl() {
        map = new HashMap<>();
        if (reverseGeocoding.getLatLng() != null) {
            map.put(Url.ReverseGeocoding.LAT_LNG, reverseGeocoding.getLatLng());
        } else {
            map.put(Url.ReverseGeocoding.PLACE_ID, reverseGeocoding.getPlaceId());
        }

        if (reverseGeocoding.getLocationTypes() != null) {
            List<ReverseLocationType> locationTypeArrayList = Arrays.asList(reverseGeocoding.getLocationTypes());
            Iterator it = locationTypeArrayList.iterator();
            StringBuilder value = new StringBuilder();
            while (it.hasNext()) {
                ReverseLocationType pair = (ReverseLocationType) it.next();
                value.append(pair.getParam());
                value.append("|");
                it.remove();
            }
            value = value.deleteCharAt(value.length() - 1);
            map.put(Url.ReverseGeocoding.LOCATION_TYPE, value.toString());
        }

        if (reverseGeocoding.getResultTypes() != null) {
            List<AddressType> locationTypeArrayList = Arrays.asList(reverseGeocoding.getResultTypes());
            Iterator it = locationTypeArrayList.iterator();
            StringBuilder value = new StringBuilder();
            while (it.hasNext()) {
                AddressType addressType = (AddressType) it.next();
                value.append(addressType.getParam());
                value.append("|");
                it.remove();
            }
            value = value.deleteCharAt(value.length() - 1);
            map.put(Url.ReverseGeocoding.RESULT_TYPE, value.toString());
        }

        if (reverseGeocoding.getLanguage() != null) {
            map.put(Url.Geocoding.LANGUAGE, reverseGeocoding.getLanguage().getParam());
        }

        map.put(Url.Geocoding.KEY, reverseGeocoding.getApiKey());

        return map;
    }
}

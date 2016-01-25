package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.constant.RequestParams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roma on 22.01.16.
 */
public class UrlBuilder {

    private Geocoding geocoding;
    private Map<String, String> map;


    public UrlBuilder(Geocoding  geocoding) {
        this.geocoding = geocoding;
    }

    public Map<String, String> buildUrl() {
        map = new HashMap<>();
        if (geocoding.getAdderess() != null) {
            map.put(RequestParams.ADDRESS, geocoding.getAdderess());
        }

        if (geocoding.getComponents() != null) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < geocoding.getComponents().length; i++) {
                value.append(geocoding.getComponents()[i]);
                if (i != geocoding.getComponents().length - 1) {
                    value.append("|");
                }
            }
            map.put(RequestParams.COMPONENTS, value.toString());
        }

        if (geocoding.getBounds() != null) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < geocoding.getBounds().length; i++) {
                value.append(geocoding.getBounds()[i]);
                if (i != geocoding.getBounds().length - 1) {
                    value.append("|");
                }
            }
            map.put(RequestParams.BOUNDS, value.toString());
        }

        if (geocoding.getLanguage() != null) {
            map.put(RequestParams.LANGUAGE, geocoding.getLanguage());
        }

        if (geocoding.getRegion() != null) {
            map.put(RequestParams.REGION, geocoding.getRegion());
        }

        map.put(RequestParams.KEY, geocoding.getApiKey());

        return map;
    }
}

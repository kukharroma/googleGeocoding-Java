package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.Url;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by roma on 22.01.16.
 */
public class UrlBuilder {

    private Geocoding geocoding;
    private Map<String, String> map;

    public UrlBuilder(Geocoding geocoding) {
        this.geocoding = geocoding;
    }

    public Map<String, String> buildUrl() {
        map = new HashMap<>();
        if (geocoding.getAddress() != null) {
            map.put(Url.Geocoding.ADDRESS, geocoding.getAddress());
        }

        if (geocoding.getComponents() != null) {
            Iterator it = geocoding.getComponents().entrySet().iterator();
            StringBuilder value = new StringBuilder();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                value.append(pair.getKey()).append(":").append(pair.getValue());
                value.append("|");
                it.remove();
            }
            value = value.deleteCharAt(value.length() - 1);
            map.put(Url.Geocoding.COMPONENTS, value.toString());
        }

        if (geocoding.getBounds() != null) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < geocoding.getBounds().length; i++) {
                value.append(geocoding.getBounds()[i]);
                if (i != geocoding.getBounds().length - 1) {
                    value.append("|");
                }
            }
            map.put(Url.Geocoding.BOUNDS, value.toString());
        }

        if (geocoding.getLanguage() != null) {
            map.put(Url.Geocoding.LANGUAGE, geocoding.getLanguage());
        }

        if (geocoding.getRegion() != null) {
            map.put(Url.Geocoding.REGION, geocoding.getRegion());
        }

        map.put(Url.Geocoding.KEY, geocoding.getApiKey());

        return map;
    }
}

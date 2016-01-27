package com.winguys.geocoding.api.mapBuilder;

import com.winguys.geocoding.api.Url;
import com.winguys.geocoding.geocoding.Geocoding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by roma on 22.01.16.
 */
public class GeocodingMapBuilder extends QueryMapBuilder{

    private Geocoding geocoding;

    public GeocodingMapBuilder(Geocoding geocoding) {
        this.geocoding = geocoding;
    }

    @Override
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
            map.put(Url.Geocoding.LANGUAGE, geocoding.getLanguage().getParam());
        }

        if (geocoding.getRegion() != null) {
            map.put(Url.Geocoding.REGION, geocoding.getRegion().getParam());
        }

        map.put(Url.Geocoding.KEY, geocoding.getApiKey());

        return map;
    }
}

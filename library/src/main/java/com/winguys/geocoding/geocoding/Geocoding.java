package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roma on 22.01.16.
 */
public class Geocoding {

    private String address;
    private Map<String, String> componentsMap;
    private String apiKey;
    private String[] bounds;
    private String language;
    private String region;

    private OnGeocodingResultListener listener;

    public String getAddress() {
        return address;
    }

    public Map<String, String> getComponents() {
        return componentsMap;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String[] getBounds() {
        return bounds;
    }

    public String getLanguage() {
        return language;
    }

    public String getRegion() {
        return region;
    }

    public void execute() {
        com.winguys.geocoding.api.UrlBuilder urlBuilder = new com.winguys.geocoding.api.UrlBuilder(this);
        RestClient.getInstance().getGeocodeService().makeGeocoding(urlBuilder.buildUrl());

    }


    public static Builder newBuilder() {
        return new Geocoding().new Builder();
    }

    public class Builder {

        public Builder setApiKey(String apiKey) {
            Geocoding.this.apiKey = apiKey;
            return this;
        }

        public Builder setAddress(String address) {
            Geocoding.this.address = address;
            return this;
        }

        public Builder setComponents(String route, String locality, String administrativeArea, String postalCode, String country) {
            Geocoding.this.componentsMap = new HashMap<>();
            Geocoding.this.componentsMap.put(Url.Components.ROUTE, route);
            Geocoding.this.componentsMap.put(Url.Components.LOCALITY, locality);
            Geocoding.this.componentsMap.put(Url.Components.ADMINISTRATIVE_AREA, administrativeArea);
            Geocoding.this.componentsMap.put(Url.Components.POSTAL_CODE, postalCode);
            Geocoding.this.componentsMap.put(Url.Components.COUNTRY, country);
            return this;
        }

        public Builder setBounds(String... bounds) {
            Geocoding.this.bounds = bounds;
            return this;
        }

        public Builder setLanguage(String language) {
            Geocoding.this.language = language;
            return this;
        }

        public Builder setRegion(String region) {
            Geocoding.this.region = region;
            return this;
        }

        public Geocoding build() {
            if (Geocoding.this.apiKey.isEmpty())
                throw new IllegalArgumentException("Please set api key for geocoding");
            if (Geocoding.this.address.isEmpty() && Geocoding.this.componentsMap == null)
                throw new IllegalArgumentException("Please set address or components for geocoding");
            if (listener == null) {
                throw new IllegalArgumentException("Please set OnGeocodingListener for geocoding");
            }
            return Geocoding.this;
        }
    }
}

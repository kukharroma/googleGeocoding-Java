package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.constant.RequestParams;

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

    /**
     * fields for components parameter
     */
    private String route;
    private String locaity;
    private String administrativeArea;
    private String postalCode;
    private String country;

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
            Geocoding.this.componentsMap.put(RequestParams.ROUTE, route);
            Geocoding.this.componentsMap.put(RequestParams.LOCALITY, locality);
            Geocoding.this.componentsMap.put(RequestParams.ADMINISTRATIVE_AREA, administrativeArea);
            Geocoding.this.componentsMap.put(RequestParams.POSTAL_CODE, postalCode);
            Geocoding.this.componentsMap.put(RequestParams.COUNTRY, country);
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
            return Geocoding.this;
        }
    }
}

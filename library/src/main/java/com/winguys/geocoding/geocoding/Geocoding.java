package com.winguys.geocoding.geocoding;

/**
 * Created by roma on 22.01.16.
 */
public class Geocoding {

    private String address;
    private String[] components;
    private String apiKey;
    private String bounds;
    private String language;
    private String region;

    private OnGeocodingResultListener listner;

    public String getAdderess() {
        return adderess;
    }

    public String[] getComponents() {
        return components;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBounds() {
        return bounds;
    }

    public String getLanguage() {
        return language;
    }

    public String getRegion() {
        return region;
    }

    public void execute() {

    }

    public void execute(OnGeocodingResultListener listener) {

    }

    public static Builder newBuilder() {
        return new Geocoding().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setApiKey(String apiKey) {
            Geocoding.this.apiKey = apiKey;
            return this;
        }

        public Builder setAddress(String address) {
            Geocoding.this.address = address;
            return this;
        }

        public Builder setComponents(String... components) {
            Geocoding.this.components = components;
            return this;
        }

        public Builder setBounds(String bounds) {
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
            if(Geocoding.this.apiKey.isEmpty())
                throw new IllegalArgumentException("Please set api key for geocoding");
            if(Geocoding.this.address.isEmpty())
                throw new IllegalArgumentException("Please set address for geocoding");
            if(Geocoding.this.components.isEmpty())
                throw new IllegalArgumentException("Please set components for geocoding");
            return Geocoding.this;
        }
    }
}

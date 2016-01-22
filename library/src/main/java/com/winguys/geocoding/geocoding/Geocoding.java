package com.winguys.geocoding.geocoding;

/**
 * Created by roma on 22.01.16.
 */
public class Geocoding {

    private String adderess;
    private String components;
    private String apiKey;
    private String bounds;
    private String language;
    private String region;

    public static Builder newBuilder(){
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
            Geocoding.this.adderess = address;
            return this;
        }

        public Builder setComponents(String... components) {
            Geocoding.this.components = components[0];
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

        public Builder setRegion(String region){
            Geocoding.this.region = region;
            return this;
        }

        public Geocoding build() {
            return Geocoding.this;
        }
    }
}

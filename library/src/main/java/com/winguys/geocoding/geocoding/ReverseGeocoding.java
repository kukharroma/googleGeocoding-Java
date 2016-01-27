package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.constant.AddressType;
import com.winguys.geocoding.api.constant.Language;
import com.winguys.geocoding.api.constant.ReverseLocationType;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseGeocoding {

    private String latitude;
    private String longitude;
    private String placeId;
    private ReverseLocationType[] locationTypes;
    private AddressType[] resultTypes;
    private String apiKey;
    private Language language;

    private OnGeocodingResultListener listener;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public ReverseLocationType[] getLocationTypes() {
        return locationTypes;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getPlaceId() {
        return placeId;
    }

    public AddressType[] getResultTypes() {
        return resultTypes;
    }

    public Language getLanguage() {
        return language;
    }

    public void setListener(OnGeocodingResultListener listener) {
        this.listener = listener;
    }

    public void execute() {
        if (listener == null)
            throw new IllegalArgumentException("Please set OnReverseGeocodingListener for reverseGeocoding");
        ReverseGeocodingUseCase geocodingUseCase = new ReverseGeocodingUseCase();
        geocodingUseCase.execute(this, listener);
    }

    public void execute(OnGeocodingResultListener listener) {
        ReverseGeocodingUseCase geocodingUseCase = new ReverseGeocodingUseCase();
        geocodingUseCase.execute(this, listener);
    }

    public static Builder newBuilder() {
        return new ReverseGeocoding().new Builder();
    }

    public class Builder {

        public Builder setApiKey(String apiKey) {
            ReverseGeocoding.this.apiKey = apiKey;
            return this;
        }

        public Builder setLatLng(String latitude, String longitude) {
            if (latitude == null)
                throw new IllegalArgumentException("Latitude cannot be null");
            ReverseGeocoding.this.latitude = latitude;
            if (longitude == null)
                throw new IllegalArgumentException("Longitude cannot be null");
            ReverseGeocoding.this.longitude = longitude;
            return this;
        }

        public Builder setPlaceId(String placeId) {
            ReverseGeocoding.this.placeId = placeId;
            return this;
        }

        public Builder setLocationTypes(ReverseLocationType... locationTypes) {
            ReverseGeocoding.this.locationTypes = locationTypes;
            return this;
        }

        public Builder setResultTypes(AddressType... addressTypes) {
            ReverseGeocoding.this.resultTypes = addressTypes;
            return this;
        }


        public Builder setLanguage(Language language) {
            ReverseGeocoding.this.language = language;
            return this;
        }

        public ReverseGeocoding build() {
            if (ReverseGeocoding.this.apiKey.isEmpty())
                throw new IllegalArgumentException("Please set api key for geocoding");
            if (ReverseGeocoding.this.latitude == null & ReverseGeocoding.this.longitude == null & ReverseGeocoding.this.placeId == null)
                throw new IllegalArgumentException("Please set latLng or place id for reverse geocoding");
            if (ReverseGeocoding.this.latitude != null & ReverseGeocoding.this.longitude != null & ReverseGeocoding.this.placeId != null)
                throw new IllegalArgumentException("Please set LatLng or place  identifier for reverse geocoding, but not together.");
            return ReverseGeocoding.this;
        }
    }
}

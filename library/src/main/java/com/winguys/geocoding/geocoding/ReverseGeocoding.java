package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.constant.AddressType;
import com.winguys.geocoding.api.constant.Language;
import com.winguys.geocoding.api.constant.ReverseLocationType;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public class ReverseGeocoding {

    private String latLng;
    private String placeId;
    private ReverseLocationType[] locationTypes;
    private AddressType[] resultTypes;
    private String apiKey;
    private Language language;

    private OnGeocodingResultListener listener;

    public String getLatLng() {
        return latLng;
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

        public Builder setLatLng(String latLng) {
            ReverseGeocoding.this.latLng = latLng;
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
            if (ReverseGeocoding.this.latLng.isEmpty() || ReverseGeocoding.this.placeId.isEmpty())
                throw new IllegalArgumentException("Please set latLng or place id for reverse geocoding");
            if (!ReverseGeocoding.this.latLng.isEmpty() & !ReverseGeocoding.this.placeId.isEmpty())
                throw new IllegalArgumentException("Please set LatLng or place  identifier for reverse geocoding, but not together.");
            if (listener == null)
                throw new IllegalArgumentException("Please set OnReverseGeocodingListener for reverseGeocoding");
            return ReverseGeocoding.this;
        }
    }
}

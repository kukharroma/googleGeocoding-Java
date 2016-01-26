package com.winguys.geocoding.api.constant;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public enum ReverseLocationType {

    ROOFTOP("ROOFTOP"),
    RANGE_INTERPOLATED("RANGE_INTERPOLATED"),
    GEOMETRIC_CENTER("GEOMETRIC_CENTER"),
    APPROXIMATE("APPROXIMATE");

    ReverseLocationType(String parameter) {
        this.param = parameter;
    }

    private final String param;

    public String getParam() {
        return param;
    }
}

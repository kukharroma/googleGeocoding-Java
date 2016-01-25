package com.winguys.geocoding.api.constant;

/**
 * Created by Stafiiyevskyi on 25.01.2016.
 */
public enum RequiredParameter {

    ADDRESS("address"), LAT_LNG("latlng");

    RequiredParameter(String str) {
        this.parameter = str;
    }

    private final String parameter;

    public String getParameter() {
        return parameter;
    }
}

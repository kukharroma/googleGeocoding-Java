package com.winguys.geocoding.geocoding;


import com.winguys.geocoding.api.Url;

/**
 * Created by roma on 22.01.16.
 */
public class UrlBuilder {

    public UrlBuilder(Geocoding.Builder builder) {
        StringBuilder baseUrl = new StringBuilder(Url.BASE_URL);
        baseUrl.append(Url.JSON_TYPE);
    }

    private String buildUrl(){
        return null;
    }


}

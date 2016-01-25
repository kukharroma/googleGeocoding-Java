package com.winguys.geocoding.geocoding;

import com.winguys.geocoding.api.Url;
import com.winguys.geocoding.constant.RequestParams;

/**
 * Created by roma on 22.01.16.
 */
public class UrlBuilder {

    private Geocoding geocoding;
    private String baseUrl = Url.BASE_URL + Url.JSON_TYPE;


    public UrlBuilder(Geocoding.Builder builder) {
        this.geocoding = builder.build();
    }

    private String buildUrl() {
        StringBuffer resultUrl = new StringBuffer(baseUrl);
        if (geocoding.getAdderess() != null) {
            String address = RequestParams.ADDRESS + "=" + geocoding.getAdderess();
            resultUrl.append(address);
        }
        if (geocoding.getComponents() != null) {

        }
    };
}

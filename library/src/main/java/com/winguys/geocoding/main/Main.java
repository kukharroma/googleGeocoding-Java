package com.winguys.geocoding.main;


import com.winguys.geocoding.geocoding.Geocoding;
import com.winguys.geocoding.api.UrlBuilder;

/**
 * Created by roma on 25.01.16.
 */
public class Main {

    public static void main(String[] args) {
        Geocoding geocoding = Geocoding.newBuilder().setAddress("address")
                .setComponents("qewrty", "123456", "adsfdsfasdf", "123540", "England")
                .setBounds("34.172684,-118.604794", "34.236144,-118.500938")
                .setApiKey("56466488949").build();
        UrlBuilder urlBuilder = new UrlBuilder(geocoding);

        urlBuilder.buildUrl();

    }

}

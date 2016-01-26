package com.winguys.geocoding.api.constant;

/**
 * Created by Stafiiyevskyi on 26.01.2016.
 */
public enum AddressType {

    COUNTRY("country"), ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
    ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
    ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
    ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),
    ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),
    COLLOQUIAL_AREA("colloquial_area"),
    LOCALITY("locality"),
    WARD("ward"),
    NEIGHBORHOOD("neighborhood"),
    PREMISE("premise"),
    SUBPREMISE("subpremise"),
    POSTAL_CODE("postal_code"),
    NATURAL_FEATURE("natural_feature"),
    AIRPORT("airport"),
    PARK("park"),
    SUBLOCALITY_LEVEL_1("sublocality_level_1"),
    SUBLOCALITY_LEVEL_2("sublocality_level_2"),
    SUBLOCALITY_LEVEL_3("sublocality_level_3"),
    SUBLOCALITY_LEVEL_4("sublocality_level_4"),
    SUBLOCALITY_LEVEL_5("sublocality_level_5"),
    FLOOR("floor"),
    ESTABLISHMENT("establishment"),
    POINT_OF_INTEREST("point_of_interest"),
    PARKING("parking"),
    POST_BOX("post_box"),
    POSTAL_TOWN("postal_town"),
    ROOM("room"),
    STREET_NUMBER("street_number"),
    BUS_STATION("bus_station"),
    TRAIN_STATION("train_station"),
    TRANSIT_STATION("transit_station");

    private final String param;

    AddressType(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}

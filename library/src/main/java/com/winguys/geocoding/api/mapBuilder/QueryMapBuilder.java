package com.winguys.geocoding.api.mapBuilder;

import java.util.Map;

/**
 * Created by roma on 27.01.16.
 */
public abstract class QueryMapBuilder {

    protected Map<String, String> map;

    public abstract Map<String, String> buildUrl();
}

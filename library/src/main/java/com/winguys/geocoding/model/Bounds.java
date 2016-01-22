package com.winguys.geocoding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Stafiiyevskyi on 18.01.2016.
 */


public class Bounds {

    @SerializedName("northeast")
    @Expose
    private Northeast northeast;
    @SerializedName("southwest")
    @Expose
    private Southwest southwest;

    /**
     *
     * @return
     * The northeast
     */
    public Northeast getNortheast() {
        return northeast;
    }

    /**
     *
     * @param northeast
     * The northeast
     */
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    /**
     *
     * @return
     * The southwest
     */
    public Southwest getSouthwest() {
        return southwest;
    }

    /**
     *
     * @param southwest
     * The southwest
     */
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

}
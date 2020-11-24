package com.test.testvidio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Jokes implements Serializable {
    @SerializedName("icon_url")
    private String iconUrl;
    private String id;
    private String url;
    private String value;
    private String[] categories;
    @SerializedName("updated_at")
    private String updated;


    public String getId() {
        return id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

    public String getUpdated() {
        return updated;
    }

    public String[] getCategories() {
        return categories;
    }
}

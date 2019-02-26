package com.punwald.seyirdefteri.models;

import com.google.gson.annotations.SerializedName;

public class RatingsItem {

    @SerializedName("Value")
    private String value;

    @SerializedName("Source")
    private String source;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return
                "RatingsItem{" +
                        "value = '" + value + '\'' +
                        ",source = '" + source + '\'' +
                        "}";
    }
}
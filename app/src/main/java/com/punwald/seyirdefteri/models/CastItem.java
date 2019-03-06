package com.punwald.seyirdefteri.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CastItem implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("picture")
    private String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return
                "CastItem{" +
                        "name = '" + name + '\'' +
                        ",picture = '" + picture + '\'' +
                        "}";
    }
}
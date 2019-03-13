package com.punwald.seyirdefteri.model.crew;

import com.google.gson.annotations.SerializedName;

public class CrewResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("picture")
    private String picture_url;

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return picture_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPictureUrl(String picture_url) {
        this.picture_url = picture_url;
    }
}

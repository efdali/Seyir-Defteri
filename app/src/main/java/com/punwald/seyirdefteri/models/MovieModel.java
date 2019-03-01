package com.punwald.seyirdefteri.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieModel implements Serializable {

    @SerializedName("summary")
    private String summary;

    @SerializedName("date")
    private String date;

    @SerializedName("cast")
    private List<CastItem> cast;

    @SerializedName("imdb")
    private String imdb;

    @SerializedName("director")
    private List<Director> director;

    @SerializedName("name")
    private String name;

    @SerializedName("time")
    private String time;

    @SerializedName("poster")
    private String poster;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CastItem> getCast() {
        return cast;
    }

    public void setCast(List<CastItem> cast) {
        this.cast = cast;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public List<Director> getDirector() {
        return director;
    }

    public void setDirector(List<Director> director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return
                "MovieModel{" +
                        "summary = '" + summary + '\'' +
                        ",date = '" + date + '\'' +
                        ",cast = '" + cast + '\'' +
                        ",imdb = '" + imdb + '\'' +
                        ",director = '" + director + '\'' +
                        ",name = '" + name + '\'' +
                        ",time = '" + time + '\'' +
                        ",poster = '" + poster + '\'' +
                        "}";
    }
}
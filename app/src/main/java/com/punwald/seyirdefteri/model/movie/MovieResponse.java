package com.punwald.seyirdefteri.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.punwald.seyirdefteri.model.crew.CrewResponse;

import java.util.List;
@Entity(tableName = "movies")
public class MovieResponse {

    @SerializedName("id")
    @PrimaryKey
    private int mid;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @SerializedName("title")
    private String title;

    @SerializedName("poster")
    private String poster_path;

    @SerializedName("overview")
    private String overview;

    @SerializedName("date")
    private String release_date;

    @SerializedName("time")
    private String time;

    @SerializedName("imdb")
    private String imdb;
    @Ignore
    @SerializedName("cast")
    private List<CrewResponse> cast;
    @Ignore
    @SerializedName("director")
    private List<CrewResponse> crew;

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTime() {
        return time;
    }

    public String getImdb() {
        return imdb;
    }

    public List<CrewResponse> getCast() {
        return cast;
    }

    public List<CrewResponse> getCrew() {
        return crew;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public void setCast(List<CrewResponse> cast) {
        this.cast = cast;
    }

    public void setCrew(List<CrewResponse> crew) {
        this.crew = crew;
    }
}

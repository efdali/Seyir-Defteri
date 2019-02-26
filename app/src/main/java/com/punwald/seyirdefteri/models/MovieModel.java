package com.punwald.seyirdefteri.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModel {

    @SerializedName("Metascore")
    private String metascore;

    @SerializedName("BoxOffice")
    private String boxOffice;

    @SerializedName("Website")
    private String website;

    @SerializedName("imdbRating")
    private String imdbRating;

    @SerializedName("imdbVotes")
    private String imdbVotes;

    @SerializedName("Ratings")
    private List<RatingsItem> ratings;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Language")
    private String language;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Production")
    private String production;

    @SerializedName("Released")
    private String released;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Director")
    private String director;

    @SerializedName("Title")
    private String title;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Response")
    private String response;

    @SerializedName("Type")
    private String type;

    @SerializedName("Awards")
    private String awards;

    @SerializedName("DVD")
    private String dVD;

    @SerializedName("Year")
    private String year;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Country")
    private String country;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Writer")
    private String writer;

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public List<RatingsItem> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingsItem> ratings) {
        this.ratings = ratings;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getDVD() {
        return dVD;
    }

    public void setDVD(String dVD) {
        this.dVD = dVD;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return
                "MovieModel{" +
                        "metascore = '" + metascore + '\'' +
                        ",boxOffice = '" + boxOffice + '\'' +
                        ",website = '" + website + '\'' +
                        ",imdbRating = '" + imdbRating + '\'' +
                        ",imdbVotes = '" + imdbVotes + '\'' +
                        ",ratings = '" + ratings + '\'' +
                        ",runtime = '" + runtime + '\'' +
                        ",language = '" + language + '\'' +
                        ",rated = '" + rated + '\'' +
                        ",production = '" + production + '\'' +
                        ",released = '" + released + '\'' +
                        ",imdbID = '" + imdbID + '\'' +
                        ",plot = '" + plot + '\'' +
                        ",director = '" + director + '\'' +
                        ",title = '" + title + '\'' +
                        ",actors = '" + actors + '\'' +
                        ",response = '" + response + '\'' +
                        ",type = '" + type + '\'' +
                        ",awards = '" + awards + '\'' +
                        ",dVD = '" + dVD + '\'' +
                        ",year = '" + year + '\'' +
                        ",poster = '" + poster + '\'' +
                        ",country = '" + country + '\'' +
                        ",genre = '" + genre + '\'' +
                        ",writer = '" + writer + '\'' +
                        "}";
    }
}
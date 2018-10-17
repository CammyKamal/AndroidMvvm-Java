package com.kamal.archcompnonents.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kamal Vaid
 * Model Class for Movie Data
 */

@Entity(tableName = "movies")
public class Movie {

    @SerializedName("poster_path")
    @ColumnInfo(name = "posterPath")
    private String posterPath;
    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    private boolean adult;
    @SerializedName("overview")
    @ColumnInfo(name = "posterPoverviewath")
    private String overview;
    @SerializedName("release_date")
    @ColumnInfo(name = "releaseDate")
    private String releaseDate;
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    private Integer id;
    @SerializedName("original_title")
    @ColumnInfo(name = "originalTitle")
    private String originalTitle;
    @SerializedName("original_language")
    @ColumnInfo(name = "originalLanguage")
    private String originalLanguage;
    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdropPath")
    private String backdropPath;
    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    private Double popularity;
    @SerializedName("vote_count")
    @ColumnInfo(name = "voteCount")
    private Integer voteCount;
    @SerializedName("video")
    @ColumnInfo(name = "video")
    private Boolean video;
    @SerializedName("vote_average")
    @ColumnInfo(name = "voteAverage")
    private Double voteAverage;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

}

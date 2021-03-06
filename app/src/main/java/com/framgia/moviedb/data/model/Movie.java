package com.framgia.moviedb.data.model;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.moviedb.utils.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by anh on 19/09/2017.
 */

public class Movie extends BaseModel implements Parcelable {
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @SerializedName("original_title")
    @Expose
    private String mTitle;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("poster_path")
    @Expose
    private String mPosterUrl;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("release_date")
    @Expose
    private Date mReleaseDate;
    private String mTrailerUrl;
    @SerializedName("production_companies")
    @Expose
    private List<Productor> mProductors;
    private List<Actor> mActors;
    @SerializedName("genres")
    @Expose
    private List<Genre> mGenres;

    protected Movie(Parcel in) {
        setId(in.readInt());
        mTitle = in.readString();
        mVoteAverage = in.readFloat();
        mPosterUrl = in.readString();
        mOverview = in.readString();
        mTrailerUrl = in.readString();
        mReleaseDate = new Date(in.readLong());
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return mTrailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.mTrailerUrl = trailerUrl;
    }

    @Bindable
    public String getPosterUrl() {
        return mPosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        mPosterUrl = posterUrl;
    }

    public List<Productor> getProductors() {
        return mProductors;
    }

    public void setProductors(List<Productor> productors) {
        mProductors = productors;
    }

    public List<Actor> getActors() {
        return mActors;
    }

    public void setActors(List<Actor> actors) {
        mActors = actors;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    @Bindable
    public String getDate() {
        SimpleDateFormat dt = new SimpleDateFormat(Constant.DATE_FORMAT_DDMMYYYY, Locale.US);
        return dt.format(mReleaseDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(mTitle);
        parcel.writeFloat(mVoteAverage);
        parcel.writeString(mPosterUrl);
        parcel.writeString(mOverview);
        parcel.writeString(mTrailerUrl);
        parcel.writeLong(mReleaseDate.getTime());
    }
}

package com.example.joseph.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;
// code reference : https://guides.codepath.com/android/using-parcelable
// This class helps in gathering all the data of each item clicked in the main Activity to be moved
// to the detailActivity for display. Data carried along include the following:
// movie Title, movie Image, overview,  Release date, user Rating
public class MyParcelable implements Parcelable {

    private String movieTitle;  // This is the movie title
    private String movieImage;     // Thumbnail or movie poster image
    private String overview;    // a plot synopsis (called overview in the api)
    private String releaseDate; // the release date of the movie
    private int userRating;  // called vote_average in the api
    private String movieId; // this is the id for the movie clicked, which is the most important factor needed in playing the movie trailer



    protected MyParcelable(Parcel in) {
        movieTitle = in.readString();
        movieImage = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        userRating = in.readInt();
        movieId = in.readString();

    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    public MyParcelable() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(movieTitle);
        dest.writeString(movieImage);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeInt(userRating);
        dest.writeString(movieId);
    }
}

package br.ramongreim.movies_app_java.movieapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    private int id;
    //private String type;
    private String disambiguation;
    private int runningTimeInMinutes;
    private String title;
    private String titleType;
    private int year;
    private String sliderName;
    private String poster_path;
    public class Image{
        private String url;
    }


    public MovieModel(int id, String disambiguation, int runningTimeInMinutes, String title,String titleType, int year, String poster_path) {
        this.id = id;
        //this.type = type;
        this.disambiguation = disambiguation;
        this.runningTimeInMinutes = runningTimeInMinutes;
        this.title = title;
        this.titleType = titleType;
        this.year = year;
        this.poster_path = poster_path;
    }

    protected MovieModel(Parcel in) {
        id = in.readInt();
        disambiguation = in.readString();
        runningTimeInMinutes= in.readInt();
        title = in.readString();
        titleType = in.readString();
        title = in.readString();
        year = in.readInt();
        poster_path = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getDisambiguation() {
        return disambiguation ;
    }

    public int getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitleType() {
        return titleType;
    }

    public int getYear() {
        return year;
    }

    public String getSliderName() {
        return sliderName;
    }

    public void setSliderName(String sliderName) {
        this.sliderName = sliderName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeString(disambiguation);
        parcel.writeInt(runningTimeInMinutes);
        parcel.writeString(title);
        parcel.writeString(titleType);
        parcel.writeInt(year);
        parcel.writeString(poster_path);

    }
}

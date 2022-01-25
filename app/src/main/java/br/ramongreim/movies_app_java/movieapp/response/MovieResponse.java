package br.ramongreim.movies_app_java.movieapp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.ramongreim.movies_app_java.movieapp.models.MovieModel;

//for single movie request
public class MovieResponse {
    // 1 - finding the movie object
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie(){
        return movie;
    }

}

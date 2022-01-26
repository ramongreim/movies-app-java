package br.ramongreim.movies_app_java.movieapp.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.ramongreim.movies_app_java.movieapp.models.MovieModel;

public class MovieApiClient {
    private static MovieApiClient instance;

    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    public static MovieApiClient getInstance(){
        if(instance == null){
                instance = new MovieApiClient();
        }
        return instance;
    }

    private MovieApiClient(){
        mMovies = new MutableLiveData<>();
    }
    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;
    }
}

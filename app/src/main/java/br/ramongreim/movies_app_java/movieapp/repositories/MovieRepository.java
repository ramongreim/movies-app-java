package br.ramongreim.movies_app_java.movieapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.ramongreim.movies_app_java.movieapp.models.MovieModel;
import br.ramongreim.movies_app_java.movieapp.request.MovieApiClient;

public class MovieRepository {

    private static MovieRepository instance;
    private MovieApiClient movieApiClient;

   //private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    public static MovieRepository getInstance(){
        if( instance == null ){
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
       movieApiClient = MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies(){return movieApiClient.getMovies();}
}

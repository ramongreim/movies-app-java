package br.ramongreim.movies_app_java.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.ramongreim.movies_app_java.movieapp.models.MovieModel;
import br.ramongreim.movies_app_java.movieapp.repositories.MovieRepository;

public class MovieListViewModel  extends ViewModel {

    //
    //private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    //constructor
    private MovieRepository movieRepository;

    public MovieListViewModel(){
        movieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){ return movieRepository.getMovies(); }
}

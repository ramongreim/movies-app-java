package br.ramongreim.movies_app_java.movieapp.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import br.ramongreim.movies_app_java.movieapp.models.MovieModel;
import br.ramongreim.movies_app_java.movieapp.response.MovieSearchResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

//@Header("x-rapidapi-key:", "d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32")
@Headers({"x-rapidapi-host: imdb8.p.rapidapi.com",
            "x-rapidapi-key: d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32"})
@GET("/title/get-most-popular-movies")
Call<JsonArray> getPopularMovies(

);

@Headers({"x-rapidapi-host: imdb8.p.rapidapi.com",
        "x-rapidapi-key: d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32"})
@GET("/title/get-details")
Call<JsonObject> getMoviesDetails(
        @Query("tconst") String tconst
);




}




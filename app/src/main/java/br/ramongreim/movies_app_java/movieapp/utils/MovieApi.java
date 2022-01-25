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
    //search for movies
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

    @GET("/3/search/movie")
    Call<JsonObject> searchMovie2(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

    @GET("/3/movie/{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("query") String api_key,
            @Query("page") String page
    );
//    @GET("/title/get-most-popular-movies")
//    Call<MovieSearchResponse> getTopMovies(
//            @Header("x-rapidapi-key") String key
//            //@Query("query") String query
//
//    );
//@Header("x-rapidapi-key:", "d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32")
@Headers({"x-rapidapi-host: imdb8.p.rapidapi.com",
            "x-rapidapi-key: d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32"})
@GET("/title/get-most-popular-movies")
Call<JsonArray> getPopularMovies(
   // @Header("x-rapidapi-key") String apikey
);

@Headers({"x-rapidapi-host: imdb8.p.rapidapi.com",
        "x-rapidapi-key: d37790251emsh47763fc6cbba84cp1d0679jsn1cacf4b34a32"})
@GET("/title/get-details")
Call<JsonObject> getMoviesDetails(
        @Query("tconst") String tconst
);




}




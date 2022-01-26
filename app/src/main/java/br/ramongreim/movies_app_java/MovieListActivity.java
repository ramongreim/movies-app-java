package br.ramongreim.movies_app_java;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.ramongreim.movies_app_java.databinding.ActivityMainBinding;
import br.ramongreim.movies_app_java.movieapp.models.MovieModel;
import br.ramongreim.movies_app_java.movieapp.request.Service;
import br.ramongreim.movies_app_java.movieapp.response.MovieSearchResponse;
import br.ramongreim.movies_app_java.movieapp.utils.Credentials;
import br.ramongreim.movies_app_java.movieapp.utils.MovieApi;
import br.ramongreim.movies_app_java.movieapp.viewmodels.MovieListViewModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    Button btn;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btn = findViewById(R.id.button);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponse();

            }
        });


//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Ramon", "Teste2");
//                GetRetrofitResponse();
//            }
//        });
    }

    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {

            }
        });
    }

//    private void GetRetrofitResponse() {
//        MovieApi movieApi = Service.getMovieApi();
//
//        Call<MovieSearchResponse> responseCall = movieApi
//        .searchMovie(Credentials.API_KEY,
//                        "Jack Reacher",
//                        "1");
//        responseCall.enqueue(new Callback<MovieSearchResponse>() {
//            @Override
//            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                if(response.code() == 200){
//                    Log.d("Ramon", "the response " +Sresponse.body().toString());
//                    //List<MovieModel> movies = new List(response.body().getMovies();
//                    ArrayList<String> abc = new ArrayList<String>(response.body());
//
//                    for (MovieModel movie: movies){
//                        Log.d("Ramon", "A lista" + movie.getTitle());
//                    }
//                }
//                else{
//                    try{
//                        Log.d("Ramon", "ERror" + response.errorBody().toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//
//            }
//        });
//
//    }

    private void GetRetrofitResponse() {
        MovieApi movieApi = Service.getMovieApi();

        Call<JsonObject> responseCall = movieApi.getMoviesDetails("tt11245972");
        //Call<JsonArray> responseCall = movieApi.get();


        responseCall.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                //Log.d("Ramon", "the response " +response.body().toString());
//                try {
//                    JSONObject directorData = new JSONObject(response.toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                //String teste = response.body().toString().replace("/title/","").replace("[","").replace("]","").replace("/","");
               // String replace = teste.replace("/" , "");
//                teste.replace("[" , "");
//                teste.replace("]" , "");
                //List<String> myList = new ArrayList<String>(Arrays.asList(teste.split(",")));
               // JsonObject jsonobj = response.body().getAsJsonObject();

                String dirPic = "";

                JsonObject jsonobj = response.body();
                if (jsonobj.has("image")) {
                    JsonObject imageDirObj = jsonobj.getAsJsonObject("image");
                    dirPic = imageDirObj.get("url").toString();
                }
                if(response.code() == 200) {
                    Log.d("Ramon", "the response " +dirPic);

                }

                //String dirPic ="";







//                for(int i = 0 ; i < myList.size() ; i++ ){
//                    Log.d("Ramon" , "lista " + myList.get(i) );
//                }

                //JsonObject object = response.body();

                //parse object
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

//            @Override
//            public void onFailure(Call<JsonArray> call, Throwable t) {
//
//            }

        });

    }

    private void GetRetroFitResponseAccordingToID(){}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
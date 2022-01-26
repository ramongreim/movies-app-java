package br.ramongreim.movies_app_java.movieapp.request;

import br.ramongreim.movies_app_java.movieapp.utils.Credentials;
import br.ramongreim.movies_app_java.movieapp.utils.MovieApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//padrão singleton em java para a api
public class Service {

    public OkHttpClient getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
        return client;
    }

    static Service service = new Service();

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .client(service.getClient())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);



    public static MovieApi getMovieApi(){
        return movieApi;
    }
}

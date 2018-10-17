package com.kamal.archcompnonents.data.source.repo;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kamal.archcompnonents.data.models.Movie;
import com.kamal.archcompnonents.data.models.MoviesResponse;
import com.kamal.archcompnonents.data.source.local.MovieDatabase;
import com.kamal.archcompnonents.data.source.local.MoviesDao;
import com.kamal.archcompnonents.utils.ConfigurationConstants;
import com.kamal.archcompnonents.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Kamal Vaid
 * Movie Repository to handle API and database calls related with movies
 */
public class MovieRepo extends BaseRepo {

    private MutableLiveData<List<Movie>> movieMutableLiveData;
    private MoviesDao moviesDao;
    private Context context;

    public MovieRepo(Context context, MovieDatabase movieDatabase) {
        super(context, movieDatabase);
        mComponent.inject(MovieRepo.this);
        moviesDao = movieDatabase.moviesDao();
        this.context = context;
    }


    /**
     * Method to fetch data from DB and make Api Call if network is available
     * @return : return's mutable list contains data of movie
     */
    public MutableLiveData<List<Movie>> fetchMoviesFromRepo() {
        movieMutableLiveData = new MutableLiveData<>();
        List<Movie> movies = moviesDao.getAllMovies();
        movieMutableLiveData.setValue(movies);
        if (Utils.isNetworkAvailable(context)) {
            Call<MoviesResponse> call = mRemoteServices.getTopRatedMovies(ConfigurationConstants.MOVIE_API_KEY);
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    movieMutableLiveData.setValue(response.body().getResults());
                    moviesDao.deleteAllMovies();
                    insertMoviesIntoDb(response.body().getResults());
                }

                @Override
                public void onFailure(@NonNull Call<MoviesResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                    movieMutableLiveData.setValue(null);
                }
            });
        }


        return movieMutableLiveData;
    }

    /**
     *  Method to fetch movie details from DB as per provided movie name
     * @param movieName : name of the movie whose details needs to be fetched
     * @return : Movie object containing details of the movie
     */
    public Movie fetchMovieDetails(String movieName) {
        return moviesDao.getMoviesData(movieName);
    }

    /**
     *  Method to insert the movie response data into the DB
     * @param moviesResponse : contains movie response fetched from Server
     */
    private void insertMoviesIntoDb(List<Movie> moviesResponse) {
        for (Movie movie : moviesResponse)
            moviesDao.insertMoviesData(movie);
    }
}

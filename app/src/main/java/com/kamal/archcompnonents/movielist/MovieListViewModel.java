package com.kamal.archcompnonents.movielist;

import android.app.Application;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.usecases.MoviesUseCase;
import com.kamal.archcompnonents.corecomponents.BaseViewModel;
import com.kamal.archcompnonents.data.models.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kamal Vaid
 * View Model for Movie List Fragment
 */

public class MovieListViewModel extends BaseViewModel {

    @Inject
    MoviesUseCase fetchMoviesList;
    private List<Movie> moviesList;
    public MutableLiveData<Boolean> moviesDataChange = new MutableLiveData<>();


    /**
     * Constructor
     * @param application : application
     */
    public MovieListViewModel(@NonNull Application application) {
        super(application);
        ((App) getApplication()).getAppComponent().inject(this);
        moviesList = new ArrayList<>();
    }


    /**
     * Method to get movies list from repository via use case (local or remote)
     * @param context : context of the calling activity or fragment, required to register observe callback
     */
    public void getMoviesList(Context context) {
        //calling desire use case method to invoke repository
        MutableLiveData<List<Movie>> moviesResponseMutableLiveData = fetchMoviesList.fetchMoviesList();
        moviesResponseMutableLiveData.observe((LifecycleOwner) context, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                moviesDataChange.setValue(true);
                if (null != movies && !movies.isEmpty()) {
                    if (null != moviesList)
                        moviesList.clear();
                    if (moviesList != null) {
                        moviesList.addAll(movies);
                    }
                }
            }
        });
    }

    //getter method for movies list
    public List<Movie> getMoviesList() {
        return moviesList;
    }


}

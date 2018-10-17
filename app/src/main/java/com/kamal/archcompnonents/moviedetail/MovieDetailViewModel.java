package com.kamal.archcompnonents.moviedetail;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.usecases.MoviesUseCase;
import com.kamal.archcompnonents.corecomponents.BaseViewModel;
import com.kamal.archcompnonents.data.models.Movie;

import javax.inject.Inject;

/**
 * Created by Kamal Vaid
 * View model to handle the movies detail screen
 */

public class MovieDetailViewModel extends BaseViewModel {

    @Inject
    MoviesUseCase moviesUseCase;
    MutableLiveData<Movie> moviesResponseLiveData;
    private ObservableField<String> overview=new ObservableField<>();

    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
        ((App) getApplication()).getAppComponent().inject(this);
        moviesResponseLiveData=new MutableLiveData<>();
    }

    /**
     *  Method calling use case method to fetch data from local repository
     * @param movieName : name to the movie for which details needs to be fetched
     */
    public void fetchMovieDetail(String movieName){
        Movie moviesResponse=moviesUseCase.fetchMovieDetail(movieName);
        moviesResponseLiveData.setValue(moviesResponse);
        if(null!=moviesResponseLiveData.getValue() && null!=moviesResponseLiveData.getValue().getOverview())
        overview.set(moviesResponseLiveData.getValue().getOverview());
    }

    //Getter for getting value of movie overview
    public ObservableField<String> getOverview() {
        return overview;
    }

}

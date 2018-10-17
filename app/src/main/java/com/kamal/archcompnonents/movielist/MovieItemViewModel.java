package com.kamal.archcompnonents.movielist;

import android.app.Application;
import android.support.annotation.NonNull;

import com.kamal.archcompnonents.data.models.Movie;
import com.kamal.archcompnonents.corecomponents.BaseViewModel;
/**
 * Created by Kamal Vaid
 * View Model Class to be binded with movie list recycler view items
 */

public class MovieItemViewModel extends BaseViewModel {

    private Movie movie;

    public MovieItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void setDataModel(Movie dataModel) {
        this.movie = dataModel;
    }


    public String getMovieTitle(){
        return movie.getTitle();
    }

    public String getMovieReleaseDate(){
        return movie.getReleaseDate();
    }
}

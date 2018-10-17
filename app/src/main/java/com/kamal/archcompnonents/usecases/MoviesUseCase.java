package com.kamal.archcompnonents.usecases;

import android.arch.lifecycle.MutableLiveData;

import com.kamal.archcompnonents.data.models.Movie;
import com.kamal.archcompnonents.data.source.repo.MovieRepo;
import com.kamal.archcompnonents.daggercomponent.AppComponent;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kamal Vaid
 *  Movie Use case for handling queries related with movies for UI
 */
public class MoviesUseCase {

    @Inject
    MovieRepo userInformationRepo;

    public MoviesUseCase(AppComponent appComponent) {
        appComponent.inject(this);
    }

    /**
     * Invokes Repository method to fetch the movies
     * @return : Mutable live Data contains list of movies observed by View Model for results
     */
    public MutableLiveData<List<Movie>> fetchMoviesList(){
        return userInformationRepo.fetchMoviesFromRepo();
    }

    /**
     * Invokes Repository method to fetch movie details as per provided key
     * @param key : to be used to fetch the movie detail from DB
     * @return : Movie Object from DB
     */
    public Movie fetchMovieDetail(String key){
        return userInformationRepo.fetchMovieDetails(key);
    }

}

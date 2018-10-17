package com.kamal.archcompnonents.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.kamal.archcompnonents.data.models.Movie;

import java.util.List;

/**
 * Created by Kamal Vaid
 * Dao to handle Database queries for Movies
 */

@Dao
public interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMoviesData(Movie moviesResponse);

    @Query("SELECT * FROM movies  where  title= :key")
    Movie getMoviesData(String key);

    @Query("SELECT * FROM movies")
    List<Movie> getAllMovies();

    @Query("DELETE FROM movies")
    void deleteAllMovies();


}

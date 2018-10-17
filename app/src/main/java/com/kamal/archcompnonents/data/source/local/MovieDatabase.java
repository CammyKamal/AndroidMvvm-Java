package com.kamal.archcompnonents.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.kamal.archcompnonents.data.models.Movie;


/**
 * Created by Kamal Vaid
 * Movie Database Class using RoomDatabase
 */

@Database(entities = {Movie.class},
        version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase INSTANCE = null;
    private static final Object lock = new Object();

    public static MovieDatabase getInstance(Context context) {
        synchronized (lock) {
            if (null == INSTANCE) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase
                        .class, "movie.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
            }
            return INSTANCE;
        }
    }

    public abstract MoviesDao moviesDao();

}

package com.kamal.archcompnonents.movielist;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.kamal.archcompnonents.data.models.Movie;

import java.util.List;

/**
 * Created by Kamal Vaid.
 * Binding class for Movies Adapter
 */

public class MovieListBindings {
    @BindingAdapter({"app:moviesListData"})
    public static void moviesListAdapter(RecyclerView recyclerView, List<Movie> items) {

    }
}
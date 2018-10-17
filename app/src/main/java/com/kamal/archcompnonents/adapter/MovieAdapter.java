package com.kamal.archcompnonents.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kamal.archcompnonents.R;
import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.data.models.Movie;
import com.kamal.archcompnonents.databinding.ItemDataBinding;
import com.kamal.archcompnonents.interfaces.OnItemClickListener;
import com.kamal.archcompnonents.movielist.MovieItemViewModel;

import java.util.List;

/**
 * Created by Kamal Vaid
 * Movie Adapter to show all the movie details in Recycler View
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.DataViewHolder> {

    private List<Movie> movies;
    private static OnItemClickListener onItemClickListener;

    public MovieAdapter(List<Movie> movies, OnItemClickListener onItemClickListener) {
        this.movies = movies;
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        Movie dataModel = movies.get(position);
        MovieItemViewModel dataItemViewModel = new MovieItemViewModel(App.instance);
        dataItemViewModel.setDataModel(dataModel);
        holder.setViewModel(dataItemViewModel);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (movies == null)
            return 0;
        return this.movies.size();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }
    //Holder class for Recyler View Adapter
    static class DataViewHolder extends RecyclerView.ViewHolder {
        private ItemDataBinding binding;

        DataViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;

        }
        void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        /**
         *  Holder Class method to set up the view model object for Inflated childs
         * @param viewModel : Movie Item View Model for each row in the recyler view
         */
        void setViewModel(MovieItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }

    }
}

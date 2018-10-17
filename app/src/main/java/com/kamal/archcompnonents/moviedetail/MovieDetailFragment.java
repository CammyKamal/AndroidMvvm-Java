package com.kamal.archcompnonents.moviedetail;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kamal.archcompnonents.R;
import com.kamal.archcompnonents.corecomponents.BaseFragment;
import com.kamal.archcompnonents.dashboard.DashboardActivity;
import com.kamal.archcompnonents.databinding.FragmentMovieDetailBinding;
import com.kamal.archcompnonents.utils.AppConstants;

public class MovieDetailFragment extends BaseFragment {

    FragmentMovieDetailBinding fragmentMovieDetailBinding;
    MovieDetailViewModel movieDetailViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setViewBindings(inflater, container);
    }

    /**
     * Method to set Data-binding and View Model for the fragment
     *
     * @return View : That needs to be inflated in the fragment
     */
    private View setViewBindings(LayoutInflater inflater, ViewGroup container) {
        fragmentMovieDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_movie_detail, container, false);
        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel.class);
        fragmentMovieDetailBinding.setModel(movieDetailViewModel);
        fragmentMovieDetailBinding.executePendingBindings();
        return fragmentMovieDetailBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieDetailViewModel.fetchMovieDetail(getArguments().getString(AppConstants.MOVIE_BUNDLE_KEY));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity) getActivity()).setHeaderTitle(getArguments().getString(AppConstants.MOVIE_BUNDLE_KEY), true);
    }
}

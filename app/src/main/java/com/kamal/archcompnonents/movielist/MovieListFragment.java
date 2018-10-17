package com.kamal.archcompnonents.movielist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kamal.archcompnonents.R;
import com.kamal.archcompnonents.adapter.MovieAdapter;
import com.kamal.archcompnonents.corecomponents.BaseFragment;
import com.kamal.archcompnonents.dashboard.DashboardActivity;
import com.kamal.archcompnonents.databinding.FragmentMovieListBinding;
import com.kamal.archcompnonents.interfaces.OnItemClickListener;
import com.kamal.archcompnonents.moviedetail.MovieDetailFragment;
import com.kamal.archcompnonents.utils.AppConstants;


/**
 * Created by Kamal Vaid
 * Fragment to show list of movies
 */

public class MovieListFragment extends BaseFragment implements OnItemClickListener {

    private MovieListViewModel userListViewModel;
    private FragmentMovieListBinding fragmentMovieListBinding;
    private MovieAdapter dataAdapter;

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
        fragmentMovieListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_movie_list, container, false);
        userListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        fragmentMovieListBinding.setModel(userListViewModel);
        fragmentMovieListBinding.setLifecycleOwner(this);
        fragmentMovieListBinding.executePendingBindings();
        return fragmentMovieListBinding.getRoot();
    }


    /**
     * set up Movie recyclerView
     *
     * @param fragmentMovieListBinding as input
     */
    private void setUpListAdapter(FragmentMovieListBinding fragmentMovieListBinding) {
        fragmentMovieListBinding.movieSwipetorefresh.setRefreshing(true);
        userListViewModel.getMoviesList(getActivity());
        RecyclerView leadsRecyclerView = fragmentMovieListBinding.dataRecyclerView;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        leadsRecyclerView.setLayoutManager(mLayoutManager);
        dataAdapter = new MovieAdapter(userListViewModel.getMoviesList(), this);
        leadsRecyclerView.setAdapter(dataAdapter);
        fragmentMovieListBinding.movieSwipetorefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userListViewModel.getMoviesList(getActivity());
            }
        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Setting up the recycler view
        setUpListAdapter(fragmentMovieListBinding);
        //Observing changes for adapter list
        userListViewModel.moviesDataChange.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                dataAdapter.notifyDataSetChanged();
                if(fragmentMovieListBinding.movieSwipetorefresh.isRefreshing())
               fragmentMovieListBinding.movieSwipetorefresh.setRefreshing(false);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setHeaderTitle(getString(R.string.movies_text),false);
    }
    /**
     *  Handling Recycler View Item Click listners via Interface here and Redirecting to detail screen
     * @param position : contains value of position clicked in the recycler View
     */
    @Override
    public void onItemClick(int position) {
        //Preparing Movie Detail Fragment
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle bundle = new Bundle();
        //Setting up Movie Name which will be used to query database to fetch details of the movie in the detail screen.
        bundle.putString(AppConstants.MOVIE_BUNDLE_KEY, userListViewModel.getMoviesList().get(position).getTitle());
        movieDetailFragment.setArguments(bundle);
        //Pushing Movie Detail Fragment here
        ((DashboardActivity) getActivity()).pushFragment(movieDetailFragment, false, true, AppConstants.MOVIE_DETAIL_FRAGMENT_TAG, true);
    }
}

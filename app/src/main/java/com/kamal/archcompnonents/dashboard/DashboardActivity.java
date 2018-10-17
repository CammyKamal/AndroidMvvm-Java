package com.kamal.archcompnonents.dashboard;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.kamal.archcompnonents.R;
import com.kamal.archcompnonents.corecomponents.BaseActivity;
import com.kamal.archcompnonents.databinding.ActivityDashboardBinding;
import com.kamal.archcompnonents.movielist.MovieListFragment;
import com.kamal.archcompnonents.utils.AppConstants;

/**
 * Created by Kamal Vaid
 * It is Landling activity where user lands after splash and fragments are inflated here in a container
 */

public class DashboardActivity extends BaseActivity {
    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpViewBindings();
        pushFragment(new MovieListFragment(), false, false, AppConstants.MOVIE_FRAGMENT_TAG, true);
    }

    //Setting up the View model and Data binding for the view
    private void setUpViewBindings() {
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        DashboardViewModel dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        activityDashboardBinding.setModel(dashboardViewModel);
        activityDashboardBinding.executePendingBindings();
    }

    /**
     * Method to push the fragments
     *
     * @param fragment       : fragment to be pushed
     * @param isAdd          : boolean value if true than fragment is added else replaced
     * @param addToBackStack : if true fragment is added to back stack else not
     * @param tag            : tag of the fragment
     * @param animate        : if true than show animation while pushing the fragment
     */
    public void pushFragment(Fragment fragment, boolean isAdd, boolean addToBackStack, String tag,
                             boolean animate) {
        pushFragment(fragment, isAdd, addToBackStack, tag, true, activityDashboardBinding.container.getId());

    }

    /**
     * Method to set header title of the activity
     * @param title : title of the activity to be set
     */
    public void setHeaderTitle(String title,boolean enableHomeUp){
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(enableHomeUp);
        getSupportActionBar().setDisplayShowHomeEnabled(enableHomeUp);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                popFragments();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.kamal.archcompnonents.corecomponents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kamal Vaid
 * Base Activity to contain all the functions methods to be used by Child classes
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * Method to push fragment into main container inside dashboard
     *
     * @param fragment       : contains fragment to be inflated
     * @param isAdd          : if true means fragments is to be added in the back stack
     * @param addToBackStack : if true fragment needs to be added to back stack
     * @param tag            : contains tag of the fragment
     * @param animate        : if true fragment will be animated during inflation
     */
    public void pushFragment(Fragment fragment, boolean isAdd, boolean addToBackStack, String tag,
                             boolean animate, int container) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAdd)
            fragmentTransaction.add(container, fragment, tag);
        else
            fragmentTransaction.replace(container, fragment, tag);
        if (addToBackStack)
            fragmentTransaction.addToBackStack(tag);
        if (animate)
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        fragmentTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();

    }

    /**
     *
     */
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1)
            popFragments();
        else
            super.onBackPressed();
    }

    //Method used to pop fragments from stack
    public void popFragments() {
        getSupportFragmentManager().popBackStackImmediate();
    }

}

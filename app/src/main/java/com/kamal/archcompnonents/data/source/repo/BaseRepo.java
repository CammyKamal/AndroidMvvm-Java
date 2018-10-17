package com.kamal.archcompnonents.data.source.repo;

import android.content.Context;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.data.source.local.MovieDatabase;
import com.kamal.archcompnonents.data.source.remote.RemoteServices;
import com.kamal.archcompnonents.daggercomponent.AppComponent;

import javax.inject.Inject;

/**
 * Created by Kamal Vaid
 * Repository class to be used to Child repository for getting instances of Remote services and database
 */

public class BaseRepo {
    public static AppComponent mComponent;
    @Inject
    public RemoteServices mRemoteServices;

    public MovieDatabase movieDatabase;

    public BaseRepo(Context context, MovieDatabase movieDatabase) {
        mComponent = ((App) context).getAppComponent();
        mComponent.inject(BaseRepo.this);
        this.movieDatabase = movieDatabase;
    }
}

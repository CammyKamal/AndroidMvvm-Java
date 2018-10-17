package com.kamal.archcompnonents.daggercomponent;

import android.content.Context;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.data.source.repo.BaseRepo;
import com.kamal.archcompnonents.usecases.MoviesUseCase;
import com.kamal.archcompnonents.data.source.local.MovieDatabase;
import com.kamal.archcompnonents.data.source.repo.MovieRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private static final String TAG = ApplicationModule.class.getSimpleName();
    private final App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Context appContext() {
        return mApp;
    }

    @Provides
    @Singleton
    public MovieRepo userInformationRepo() {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(mApp);
        return new MovieRepo(mApp,movieDatabase);

    }


    @Provides
    @Singleton
    public BaseRepo baseRepo() {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(mApp);
        return new BaseRepo(mApp,movieDatabase);

    }

    @Provides
    public MoviesUseCase fetchUsers() {
        return new MoviesUseCase(mApp.getAppComponent());
    }

}

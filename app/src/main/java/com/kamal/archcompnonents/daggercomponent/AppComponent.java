package com.kamal.archcompnonents.daggercomponent;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.usecases.MoviesUseCase;
import com.kamal.archcompnonents.corecomponents.BaseActivity;
import com.kamal.archcompnonents.corecomponents.BaseFragment;
import com.kamal.archcompnonents.dashboard.DashboardViewModel;
import com.kamal.archcompnonents.data.source.repo.BaseRepo;
import com.kamal.archcompnonents.data.source.repo.MovieRepo;
import com.kamal.archcompnonents.moviedetail.MovieDetailViewModel;
import com.kamal.archcompnonents.movielist.MovieListViewModel;

import javax.inject.Singleton;

import dagger.Component;

//This class is used for injecting Fragment, View Models, Use cases using Dagger
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface AppComponent {

    void inject(DashboardViewModel dashboardViewModel);
    void inject(MovieListViewModel movieListViewModel);

    void inject(MovieDetailViewModel movieDetailViewModel);

    //Inject Activities
    void inject(BaseActivity baseActivity);

    //Inject Fragment's
    void inject(BaseFragment baseFragment);


    void inject(App transferWiseApp);

    //Inject Repo's
    void inject(MovieRepo movieRepo);

    void inject(BaseRepo baseRepo);

    void inject(MoviesUseCase moviesUseCase);

}
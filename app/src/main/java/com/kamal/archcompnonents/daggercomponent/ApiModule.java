package com.kamal.archcompnonents.daggercomponent;

import com.kamal.archcompnonents.App;
import com.kamal.archcompnonents.data.source.remote.RemoteServices;
import com.kamal.archcompnonents.data.source.remote.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    private App app;

    public ApiModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public RemoteServices remoteServices() {
        return RetrofitClient.getClient().create(RemoteServices.class);
    }
}

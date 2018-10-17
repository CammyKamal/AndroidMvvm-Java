package com.kamal.archcompnonents.data.source.remote;

import com.kamal.archcompnonents.data.models.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Kamal Vaid
 * Interface containing retrofit Api end Points
 */

public interface RemoteServices {

    @GET(ApiConstants.TOP_MOVIES_ENDPOINT)
    Call<MoviesResponse> getTopRatedMovies(@Query(ApiConstants.API_KEY_LABEL) String apiKey);

}

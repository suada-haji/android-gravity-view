package com.example.suadahaji.gravityview.api;

import com.example.suadahaji.gravityview.models.MovieResponse;
import com.example.suadahaji.gravityview.utils.Api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by suadahaji
 */

public interface ApiManager {

    @GET(Api.GET_POPULAR_MOVIES)
    Observable<MovieResponse> getPopularMovies();

    @GET(Api.GET_UPCOMING_MOVIES)
    Observable<MovieResponse> getUpcomingMovies();

    @GET(Api.GET_NOW_PLAYING_MOVIES)
    Observable<MovieResponse> getNowPlayingMovies();

}

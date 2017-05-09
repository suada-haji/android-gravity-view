package com.example.suadahaji.gravityview.presenters;

import android.util.Log;

import com.example.suadahaji.gravityview.api.ApiModule;
import com.example.suadahaji.gravityview.models.Movie;
import com.example.suadahaji.gravityview.models.MovieResponse;
import com.example.suadahaji.gravityview.views.MoviesListActivity;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by suadahaji
 */

public class ListPresenter {

    MoviesListActivity mView;
    ApiModule apiModule;

    public ListPresenter(MoviesListActivity mView, ApiModule apiModule) {
        this.mView = mView;
        this.apiModule = apiModule;
    }

    public void loadPopularMovies() {
        apiModule.getApi()
                .getPopularMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<MovieResponse>() {
                            @Override
                            public void call(MovieResponse movieResponse) {
                                if (movieResponse == null || movieResponse.getMovies() == null || movieResponse.getMovies().size() == 0) {
                                    mView.displayEmptyState();
                                }
                                mView.hideProgressBar();
                                List<Movie> movies = movieResponse.getMovies();
                                mView.displayPopularMovies(movies);

                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                mView.displayErrorState();
                                mView.hideProgressBar();
                            }
                        });

    }

    public void loadUpcomingMovies() {
        apiModule.getApi()
                .getUpcomingMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<MovieResponse>() {
                            @Override
                            public void call(MovieResponse movieResponse) {
                                if (movieResponse == null || movieResponse.getMovies() == null || movieResponse.getMovies().size() == 0) {
                                    mView.displayEmptyState();
                                    mView.hideProgressBar();
                                }
                                List<Movie> movies = movieResponse.getMovies();
                                Log.d("Suada", "Size " + movies.size());
                                mView.displayUpcomingMovies(movies);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                mView.displayErrorState();
                                mView.hideProgressBar();
                            }
                        });

    }

    public void loadNowPlayingMovies() {
        apiModule.getApi()
                .getNowPlayingMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<MovieResponse>() {
                            @Override
                            public void call(MovieResponse movieResponse) {
                                if (movieResponse == null || movieResponse.getMovies() == null || movieResponse.getMovies().size() == 0) {
                                    mView.displayEmptyState();
                                }
                                List<Movie> movies = movieResponse.getMovies();
                                mView.displayNowPlayingMovies(movies);
                                mView.hideProgressBar();
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                mView.displayErrorState();
                                mView.hideProgressBar();
                            }
                        });

    }

}

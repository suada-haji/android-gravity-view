package com.example.suadahaji.gravityview.utils;


import com.example.suadahaji.gravityview.BuildConfig;

/**
 * Created by suadahaji
 */

public class Api {
    public static final String API_KEY = BuildConfig.TMDB_API_KEY;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String GET_POPULAR_MOVIES = "movie/popular?language=en-US&sort_by=popularity.desc&api_key=" + API_KEY;
    public static final String GET_UPCOMING_MOVIES = "movie/upcoming?language=en-US&sort_by=popularity.desc&api_key=" + API_KEY;
    public static final String GET_NOW_PLAYING_MOVIES = "movie/now_playing?language=en-US&sort_by=popularity.desc&api_key=" + API_KEY;
    public static final String GET_MOVIE = "movie/{id}?api_key=" + API_KEY;
    public static final String POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";
    public static final String GET_VIDEOS = "http://api.themoviedb.org/3/movie/{id}/videos?api_key=" + API_KEY;
    public static final String GET_REVIEWS = "http://api.themoviedb.org/3/movie/{id}/reviews?api_key=" + API_KEY;
    public static final String YOUTUBE_VIDEO_URL = "http://www.youtube.com/watch?v=";
    public static final String YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/";

    private Api() {

    }
}


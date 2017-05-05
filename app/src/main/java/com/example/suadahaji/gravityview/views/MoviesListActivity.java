package com.example.suadahaji.gravityview.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.suadahaji.gravityview.R;
import com.example.suadahaji.gravityview.api.ApiModule;
import com.example.suadahaji.gravityview.models.Movie;
import com.example.suadahaji.gravityview.presenters.ListPresenter;
import com.example.suadahaji.gravityview.utils.Api;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.popular_label)
    TextView popularLabel;
    @BindView(R.id.ll_popular_movies)
    LinearLayout llPopularMovies;
    @BindView(R.id.hsv_popular_container)
    HorizontalScrollView hsvPopularMovies;

    @BindView(R.id.now_playing_label)
    TextView nowPlayingLabel;
    @BindView(R.id.ll_now_playing_movies)
    LinearLayout ll_NowPlayingMovies;
    @BindView(R.id.hsv_now_playing_container)
    HorizontalScrollView hsvNowPlayingMovies;


    @BindView(R.id.upcoming_label)
    TextView upcomingLabel;
    @BindView(R.id.ll_upcoming_movies)
    LinearLayout ll_UpcomingMovies;
    @BindView(R.id.hsv_upcoming_container)
    HorizontalScrollView hsvUpcomingMovies;

    ListPresenter presenter;
    ApiModule apiModule;

    ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        ButterKnife.bind(this);

        setToolbar();

        apiModule = new ApiModule();
        presenter = new ListPresenter(this, apiModule);
        presenter.loadPopularMovies();
        presenter.loadUpcomingMovies();
        presenter.loadNowPlayingMovies();

    }

    public void setToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("The Movie DB");

            }
        }
    }


    public void displayPopularMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            popularLabel.setVisibility(View.GONE);
            this.llPopularMovies.setVisibility(View.GONE);
            hsvPopularMovies.setVisibility(View.GONE);
        } else {
            popularLabel.setVisibility(View.VISIBLE);
            this.llPopularMovies.setVisibility(View.VISIBLE);
            hsvPopularMovies.setVisibility(View.VISIBLE);

            this.llPopularMovies.removeAllViews();
            LayoutInflater inflater = this.getLayoutInflater();
            Picasso picasso = Picasso.with(this);
            for (Movie movie : movies) {
                View movieContainer = inflater.inflate(R.layout.popular_movies, this.llPopularMovies, false);
                ImageView imageView = ButterKnife.findById(movieContainer, R.id.poster_image);
                picasso
                        .load(Api.POSTER_PATH + movie.getPosterPath())
                        .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                        .into(imageView);
                this.llPopularMovies.addView(movieContainer);
            }
        }
    }

    public void displayUpcomingMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            upcomingLabel.setVisibility(View.GONE);
            this.ll_UpcomingMovies.setVisibility(View.GONE);
            hsvUpcomingMovies.setVisibility(View.GONE);
        } else {
            upcomingLabel.setVisibility(View.VISIBLE);
            this.ll_UpcomingMovies.setVisibility(View.VISIBLE);
            hsvUpcomingMovies.setVisibility(View.VISIBLE);

            this.ll_UpcomingMovies.removeAllViews();
            LayoutInflater inflater = this.getLayoutInflater();
            Picasso picasso = Picasso.with(this);
            for (Movie movie : movies) {
                View movieContainer = inflater.inflate(R.layout.popular_movies, this.ll_UpcomingMovies, false);
                ImageView imageView = ButterKnife.findById(movieContainer, R.id.poster_image);
                picasso
                        .load(Api.POSTER_PATH + movie.getPosterPath())
                        .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                        .into(imageView);
                this.ll_UpcomingMovies.addView(movieContainer);
            }
        }
    }

    public void displayNowPlayingMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            nowPlayingLabel.setVisibility(View.GONE);
            this.ll_NowPlayingMovies.setVisibility(View.GONE);
            hsvNowPlayingMovies.setVisibility(View.GONE);
        } else {
            nowPlayingLabel.setVisibility(View.VISIBLE);
            this.ll_NowPlayingMovies.setVisibility(View.VISIBLE);
            hsvNowPlayingMovies.setVisibility(View.VISIBLE);

            this.ll_NowPlayingMovies.removeAllViews();
            LayoutInflater inflater = this.getLayoutInflater();
            Picasso picasso = Picasso.with(this);
            for (Movie movie : movies) {
                View movieContainer = inflater.inflate(R.layout.popular_movies, this.ll_NowPlayingMovies, false);
                ImageView imageView = ButterKnife.findById(movieContainer, R.id.poster_image);
                picasso
                        .load(Api.POSTER_PATH + movie.getPosterPath())
                        .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                        .into(imageView);
                this.ll_NowPlayingMovies.addView(movieContainer);
            }
        }
    }


    public void displayEmptyState() {
    }

    public void displayErrorState() {
    }
}
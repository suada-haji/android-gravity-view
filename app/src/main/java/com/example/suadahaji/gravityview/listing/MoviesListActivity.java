package com.example.suadahaji.gravityview.listing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.suadahaji.gravityview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        ButterKnife.bind(this);

        setToolbar();

    }

    public void setToolbar() {
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.buttonColor));
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("The Movie DB");

            }
        }
    }

    public void getPopularMovies() {

    }
}

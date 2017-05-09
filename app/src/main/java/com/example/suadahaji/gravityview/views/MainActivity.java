package com.example.suadahaji.gravityview.views;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suadahaji.gravityview.R;
import com.example.suadahaji.gravityview.fragments.SignInFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.gofynd.gravityview.GravityView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bg)
    ImageView bg;

    private GravityView gravityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        gravityView = GravityView.getInstance(this)
                .setImage(bg, R.drawable.background_two)
                .center();

        if (!gravityView.deviceSupported()) {
            Toast.makeText(getBaseContext(), "Gyroscope sensor not available in your device", Toast.LENGTH_LONG).show();
        }
        getSignInFragment();

    }

    public void getSignInFragment() {
        FragmentManager manager = getSupportFragmentManager();
        SignInFragment fragment = new SignInFragment();
        manager.beginTransaction()
                .replace(R.id.signinFragment, fragment)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }
}

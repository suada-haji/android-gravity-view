package com.example.suadahaji.gravityview.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.suadahaji.gravityview.listing.MoviesListActivity;
import com.example.suadahaji.gravityview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by suadahaji
 */

public class SignUpFragment extends Fragment {

    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sign_up_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoviesListActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setText(Html.fromHtml("<font color='white'>Already have an account?</font>"
                + "<font color = '#00D474'> Sign In</font>"));

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SignInFragment fragment = new SignInFragment();
                fm.beginTransaction()
                        .replace(R.id.signinFragment, fragment)
                        .commit();
            }
        });



    }
}

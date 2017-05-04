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
import android.widget.EditText;

import com.example.suadahaji.gravityview.listing.MoviesListActivity;
import com.example.suadahaji.gravityview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by suadahaji
 */

public class SignInFragment extends Fragment {

    @BindView(R.id.username)
    EditText etEmail;
    @BindView(R.id.password)
    EditText etPassword;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sign_in_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         btnSignUp.setText(Html.fromHtml("<font color='white'>Don't have an account?</font>"
        +"<font color = '#00D474'> Sign Up</font>"));

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoviesListActivity.class);
                startActivity(intent);

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SignUpFragment fragment = new SignUpFragment();
                fm.beginTransaction()
                        .replace(R.id.signinFragment, fragment)
                        .commit();
            }
        });

    }
}

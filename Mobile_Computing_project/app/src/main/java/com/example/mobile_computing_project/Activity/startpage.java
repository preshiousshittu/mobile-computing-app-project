package com.example.mobile_computing_project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_computing_project.Fragments.signInFragment;
import com.example.mobile_computing_project.Fragments.signUpFragment;
import com.example.mobile_computing_project.R;

public class startpage extends AppCompatActivity
        implements signUpFragment.SignUpCallBack, signInFragment.SignInCallBack {

    signInFragment siFrag = signInFragment.newInstance();
    signUpFragment suFrag = signUpFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.add(R.id.fragmentContainerFL, siFrag);
        trans.add(R.id.fragmentContainerFL, suFrag);
        trans.hide(suFrag);
        trans.show(siFrag);
        trans.commit();


    }

    @Override
    public void swapToSignIn() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.hide(suFrag);
        trans.show(siFrag);
        trans.commit();

    }

    @Override
    public void swapToSignUp() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.hide(siFrag);
        trans.show(suFrag);
        trans.commit();

    }
}
package com.example.mobile_computing_project.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_computing_project.Activity.MainActivity;
import com.example.mobile_computing_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link signInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signInFragment extends Fragment {
    public interface SignInCallBack {
        public void swapToSignUp();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public signInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment signInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static signInFragment newInstance() {
        signInFragment fragment = new signInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private SignInCallBack activity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (SignInCallBack) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    EditText emailET, passET, conpassET;
    Button SIsignInbtn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);
        emailET = v.findViewById(R.id.emailET);
        passET = v.findViewById(R.id.passET);
        conpassET = v.findViewById(R.id.conpassET);
        progressDialog = new ProgressDialog(this.getContext());
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        Button SIsignUpbtn = v.findViewById(R.id.SIsignUpbtn);


        SIsignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapToSignUp();
            }
        });

        SIsignInbtn = v.findViewById(R.id.SIsignInbtn);
        SIsignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuth();
                //switchToMain();
            }
        });

        return v;
    }

    private void performAuth() {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();
        String conpass = conpassET.getText().toString();

        if(!email.matches(emailPattern)) {
            emailET.setError("Enter Correct Email");
        } else if(pass.isEmpty() || pass.length() < 6) {
            passET.setError("Enter Proper Password");
        } else if(!pass.equals(conpass)) {
            conpassET.setError("Password does not match");
        } else {
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                        switchToMain();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), ""+task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    public void switchToMain() {
        Intent ini = new Intent(getActivity(), MainActivity.class);
        ini.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ini);
    }
}
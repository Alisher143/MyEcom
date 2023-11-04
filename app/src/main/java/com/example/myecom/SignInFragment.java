package com.example.myecom;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.DocumentReference;


//import java.util.HashMap;
//import java.util.Map;

//import static com.example.myecom.RegisterActivity.onResetPassFragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignInFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignInFragment() {
        // Required empty public constructor
    }
    private TextView dontHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private String pattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    public static boolean disableCloseBtn = false;

    public static SignInFragment newInstance(String param1, String param2) {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
//    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAccount = view.findViewById(R.id.tv_dont_have_an_account);
        parentFrameLayout= getActivity().findViewById(R.id.register_framelayout);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener(v -> setFragment(new SignUpFragment()));
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

//    private void checkInputs() {
//        if(!TextUtils.isEmpty(email.getText())){
//            if(!TextUtils.isEmpty(pass.getText()) && pass.length()>=8){
//                signinBtn.setEnabled(true);
//            }else{
//                signinBtn.setEnabled(false);
//            }
//        }else{
//            signinBtn.setEnabled(false);
//        }
//    }

//    private void checkEmailandPass() {
//        if(email.getText().toString().matches(pattern)){
//            if(pass.getText().length()>=8){
//
//                progressBar.setVisibility(View.VISIBLE);
//                signinBtn.setEnabled(false);
//
//                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString())
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if(task.isSuccessful()){
//                                    if(disableCloseBtn){
//                                        disableCloseBtn=false;
//                                    }else {
//                                        startActivity(new Intent(getActivity(),MainActivity.class));
//                                    }
//                                    getActivity().finish();
//                                }else {
//                                    progressBar.setVisibility(View.INVISIBLE);
//                                    signinBtn.setEnabled(true);
//                                    String error=task.getException().getMessage();
//                                    Toast.makeText(getActivity(), error,Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//
//            }else {
//                pass.setError("Password must be of 8 characters !");
//            }
//        }else {
//            email.setError("Invalid Email!");
//        }
//    }


}
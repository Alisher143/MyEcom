package com.example.myecom;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//Android Studio Electric Eel | 2022.1.1 Patch 1
//Build #AI-221.6008.13.2211.9514443, built on January 21, 2023
//Runtime version: 11.0.15+0-b2043.56-9505619 amd64
//VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
//Windows 11 10.0
//GC: G1 Young Generation, G1 Old Generation
//Memory: 1280M
//Cores: 8
//Registry:
//    external.system.auto.import.disabled=true
//    ide.text.editor.with.preview.show.floating.toolbar=false
public class SignUpFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alreadyHaveAnAccount;
    private FrameLayout parentFrameLayout;

    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        parentFrameLayout= getActivity().findViewById(R.id.register_framelayout);
        alreadyHaveAnAccount= view.findViewById(R.id.tv_already_have_an_account);
//        email= view.findViewById(R.id.sign_up_email);
//        fullName= view.findViewById(R.id.sign_up_fullname);
//        password= view.findViewById(R.id.sign_up_password);
//        confirmPassword= view.findViewById(R.id.sign_up_confirm_password);
//
//        closeBtn= view.findViewById(R.id.sign_up_close_btn);
//        signUpBtn= view.findViewById(R.id.sign_up_btn);
//
//        progressBar= view.findViewById(R.id.sign_up_progressbar);
//        firebaseAuth= FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new SignInFragment());
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
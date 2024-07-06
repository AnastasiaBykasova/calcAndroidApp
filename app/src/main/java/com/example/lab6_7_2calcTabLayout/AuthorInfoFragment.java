package com.example.lab6_7_2calcTabLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AuthorInfoFragment extends Fragment {

    public AuthorInfoFragment() {
    }

    public static AuthorInfoFragment newInstance(int page) {
        AuthorInfoFragment fragment = new AuthorInfoFragment();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_author_info, container, false);
    }
}
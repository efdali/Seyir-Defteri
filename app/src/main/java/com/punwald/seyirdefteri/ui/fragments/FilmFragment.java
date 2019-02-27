package com.punwald.seyirdefteri.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.punwald.seyirdefteri.R;

public class FilmFragment extends Fragment {


    public static FilmFragment getInstance(int position){

        Bundle bundle=new Bundle();
        bundle.putInt("pos",position);
        FilmFragment filmFragment=new FilmFragment();
        filmFragment.setArguments(bundle);

        return filmFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_film,container,false);

        TextView textView=view.findViewById(R.id.textView);
        textView.setText(getArguments().getInt("pos")+" pos");

        return view;
    }
}

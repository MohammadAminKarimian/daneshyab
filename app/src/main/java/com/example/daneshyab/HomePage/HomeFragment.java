package com.example.daneshyab.HomePage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daneshyab.HandNote;
import com.example.daneshyab.HomePage.AddPage.AddPage;
import com.example.daneshyab.MainActivity;
import com.example.daneshyab.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView inReadingRV = view.findViewById(R.id.list_in_reading);
        RecyclerView latestHandnotesRV = view.findViewById(R.id.list_last_handnotes);
        RecyclerView publicLessonsRV = view.findViewById(R.id.list_public_lessons);
        inReadingRV.setHasFixedSize(true);
        inReadingRV.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false));
        inReadingRV.setAdapter(new HomeAdapter(container.getContext(), MainActivity.getHandNotes()));
        latestHandnotesRV.setHasFixedSize(true);
        latestHandnotesRV.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false));
        latestHandnotesRV.setAdapter(new HomeAdapter(container.getContext(), MainActivity.getHandNotes()));
        publicLessonsRV.setHasFixedSize(true);
        publicLessonsRV.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false));
        publicLessonsRV.setAdapter(new HomeAdapter(container.getContext(), MainActivity.getHandNotes()));

        View floatButton = view.findViewById(R.id.home_float_button);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), AddPage.class);
                v.getContext().startActivity(mIntent);
            }
        });
//        initToolbar(view);

        return view;
    }

    private void initToolbar(View view){
        AppCompatActivity parent = (AppCompatActivity) getActivity();
        Toolbar toolbar = view.findViewById(R.id.home_toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_round_more_vert_24px);
//        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        parent.setSupportActionBar(toolbar);
//        parent.getSupportActionBar().setTitle(R.string.app_name_second);
        parent.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        parent.getSupportActionBar().setElevation(4);
    }
}

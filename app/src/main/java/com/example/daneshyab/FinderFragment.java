package com.example.daneshyab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FinderFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finder, container, false);

        ArrayList<HandNote> handNotes = new ArrayList<>();
        handNotes.add(new HandNote(879, R.drawable.temp1, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp2, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp3, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp4, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp1, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp2, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));
        handNotes.add(new HandNote(879, R.drawable.temp3, "ریاضی 2", "حمید خواجوی", "کامپیوتر", "چمران", "96/6/12", "6000"));

        RecyclerView mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerView.setAdapter(new FinderRecyclerAdapter(handNotes));

        return view;
    }
}

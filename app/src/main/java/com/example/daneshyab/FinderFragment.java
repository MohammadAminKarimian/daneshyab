package com.example.daneshyab;

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
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_finder, container, false);

        final ArrayList<HandNote> handNotes = new ArrayList<>();
        handNotes.add(new HandNote(879,R.drawable.temp1,"ریاضی 2","حمید خواجوی","کامپیوتر","صنعتی اصفهان","96/6/12","6000"));
        handNotes.add(new HandNote(879,R.drawable.temp2,"دانش خانواده","محمدرضا سیب زمینی","ریاضی","چمران","96/6/12","1250"));
        handNotes.add(new HandNote(879,R.drawable.temp3,"برنامه نویسی","محسن قاضی مرعشی","مهندسی مکانیک","دانشگاه یزد","96/6/12","3500"));
        handNotes.add(new HandNote(879,R.drawable.temp4,"فیزیک","شیرعلی احمدی","کامپیوتر","چمران","96/6/12","2000"));
        handNotes.add(new HandNote(879,R.drawable.temp1,"مبانی الکترونیک","زهره پورعلی زاده","مهندسی ربوتیک","شیراز دولتی","96/6/12","500"));
        handNotes.add(new HandNote(879,R.drawable.temp2,"دندان شناسی","نسترن معین","دندانپزشکی","چمران","96/6/12","679.5"));
        handNotes.add(new HandNote(879,R.drawable.temp3,"تربیت بدنی 3","فرهاد خیابانی","دامپزشکی","چمران","96/6/12","0000"));

        final RecyclerView mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mRecyclerView.setAdapter(new FinderRecyclerAdapter(handNotes, container.getContext()));
        return view;
    }

}

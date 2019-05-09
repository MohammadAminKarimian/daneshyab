package com.example.daneshyab.HomePage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daneshyab.HandNote;
import com.example.daneshyab.R;

import java.util.ArrayList;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.myViewHolder>{

    private Context context;
    private ArrayList<HandNote> dataset;

    public HomeAdapter(Context context, ArrayList<HandNote> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_list_item, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        HandNote object = dataset.get(i);
        myViewHolder.name.setText(object.getName());
        myViewHolder.teacher_name.setText(object.getTeacher_name());
        myViewHolder.image.setImageResource(object.getDrawable());
        myViewHolder.university.setText(object.getUniversity());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        TextView name, teacher_name, university;
        ImageView image;

        myViewHolder(View itemView){
            super(itemView);
            this.name = itemView.findViewById(R.id.home_list_item_name);
            this.teacher_name = itemView.findViewById(R.id.home_list_item_teacher_name);
            this.university = itemView.findViewById(R.id.home_list_item_university);
            this.image = itemView.findViewById(R.id.home_list_item_Image);
        }

    }
}

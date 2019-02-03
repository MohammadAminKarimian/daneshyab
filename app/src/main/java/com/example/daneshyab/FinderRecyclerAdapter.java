package com.example.daneshyab;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FinderRecyclerAdapter extends RecyclerView.Adapter<FinderRecyclerAdapter.MyViewHolder> {
    private ArrayList<HandNote> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public FinderRecyclerAdapter(ArrayList<HandNote> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FinderRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.finder_handnote_card_listview, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ImageView image;
                ArrayList<String> strs = new ArrayList<>();
                Intent mIntent = new Intent(parent.getContext(), Handnote_Overview.class);
                strs.add(((TextView) v.findViewById(R.id.price_tv)).getText().toString());
                strs.add(((TextView) v.findViewById(R.id.handnote_name_tv)).getText().toString());
                strs.add(((TextView) v.findViewById(R.id.author_tv)).getText().toString());
                strs.add(((TextView) v.findViewById(R.id.university_tv)).getText().toString());
                strs.add(((TextView) v.findViewById(R.id.field_tv)).getText().toString());
                strs.add(((TextView) v.findViewById(R.id.date_tv)).getText().toString());
//                image = (ImageView) v.findViewById(R.id.card_image);
//                String res = image.getResources().toString();
                mIntent.putStringArrayListExtra("Adapter_Strings", strs);
//                mIntent.putExtra("Adapter_image", res);
                parent.getContext().startActivity(mIntent);
//                Toast.makeText(parent.getContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        HandNote object = mDataset.get(position);
        ((MyViewHolder) holder).field.setText(object.getField());
        ((MyViewHolder) holder).university.setText(object.getUniversity());
        ((MyViewHolder) holder).handnote_name.setText(object.getName());
        ((MyViewHolder) holder).author.setText(object.getAuthor());
        ((MyViewHolder) holder).date.setText(object.getDate());
        ((MyViewHolder) holder).price.setText(object.getPrice());
        ((MyViewHolder) holder).image.setImageResource(object.getImageID());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView price, handnote_name, author, university, field, date;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.price = (TextView) itemView.findViewById(R.id.price_tv);
            this.handnote_name = (TextView) itemView.findViewById(R.id.handnote_name_tv);
            this.author = (TextView) itemView.findViewById(R.id.author_tv);
            this.university = (TextView) itemView.findViewById(R.id.university_tv);
            this.field = (TextView) itemView.findViewById(R.id.field_tv);
            this.date = (TextView) itemView.findViewById(R.id.date_tv);
            this.image = (ImageView) itemView.findViewById(R.id.card_image);
        }
    }

}

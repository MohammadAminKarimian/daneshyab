package com.example.daneshyab;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FinderRecyclerAdapter extends RecyclerView.Adapter<FinderRecyclerAdapter.MyViewHolder> {
    private ArrayList<HandNote> mDataset;
    private Context context ;

    // Provide a suitable constructor (depends on the kind of dataset)
    FinderRecyclerAdapter(ArrayList<HandNote> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context ;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FinderRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.finder_handnote_card_listview, parent, false);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final HandNote object = mDataset.get(position);
        holder.field.setText(object.getField());
        holder.university.setText(object.getUniversity());
        holder.handnote_name.setText(object.getName());
        holder.author.setText(object.getAuthor());
        holder.date.setText(object.getDate());
        holder.price.setText(object.getPrice());
        holder.image.setImageResource(object.getImageID());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, Handnote_Overview.class);
                ArrayList<String> card_strings = new ArrayList<>();
                int ImageID = object.getImageID();
                card_strings.add(object.getPrice());
                card_strings.add(object.getName());
                card_strings.add(object.getAuthor());
                card_strings.add(object.getUniversity());
                card_strings.add(object.getField());
                card_strings.add(object.getDate());
                mIntent.putStringArrayListExtra("Adapter_Strings", card_strings);
                mIntent.putExtra("Adapter_Image", ImageID);
                context.startActivity(mIntent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView price, handnote_name, author, university, field, date;
        ImageView image;
        CardView cardView ;

        MyViewHolder(View itemView) {
            super(itemView);

            this.price = itemView.findViewById(R.id.price_tv);
            this.handnote_name = itemView.findViewById(R.id.handnote_name_tv);
            this.author = itemView.findViewById(R.id.author_tv);
            this.university = itemView.findViewById(R.id.university_tv);
            this.field = itemView.findViewById(R.id.field_tv);
            this.date = itemView.findViewById(R.id.date_tv);
            this.image = itemView.findViewById(R.id.card_image);
            this.cardView = itemView.findViewById(R.id.Adapter_card_view);

        }
    }

}

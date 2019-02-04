package com.example.daneshyab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Handnote_Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handnote__overview);

        TextView price = findViewById(R.id.price);
        TextView handnote_name = findViewById(R.id.handnote_name);
        TextView author = findViewById(R.id.author);
        TextView university = findViewById(R.id.university);
        TextView field = findViewById(R.id.field);
        TextView date = findViewById(R.id.date);
        ImageView imageView = findViewById(R.id.image_view_overview);

        Intent mIntent = getIntent();
        ArrayList<String> card_strings = mIntent.getStringArrayListExtra("Adapter_Strings");
        int ImageID = mIntent.getIntExtra("Adapter_Image", 0);
        price.setText(card_strings.get(0));
        handnote_name.setText(card_strings.get(1));
        author.setText(card_strings.get(2));
        university.setText(card_strings.get(3));
        field.setText(card_strings.get(4));
        date.setText(card_strings.get(5));
        imageView.setImageResource(ImageID);
    }
}

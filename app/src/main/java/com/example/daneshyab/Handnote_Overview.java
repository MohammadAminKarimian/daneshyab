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
        ImageView imageView = findViewById(R.id.card_image);

        Intent mIntent = getIntent();
        ArrayList<String> strs = mIntent.getStringArrayListExtra("Adapter_Strings");
        price.setText(strs.get(0));
        handnote_name.setText(strs.get(1));
        author.setText(strs.get(2));
        university.setText(strs.get(3));
        field.setText(strs.get(4));
        date.setText(strs.get(5));

    }
}

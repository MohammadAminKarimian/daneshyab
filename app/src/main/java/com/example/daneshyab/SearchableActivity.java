package com.example.daneshyab;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchableActivity extends ListActivity {

    ArrayList<String> myData = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        myData.add("big");
        myData.add("bash");
        myData.add("boom");

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //  TODO with query that we got  from user now we must search our database for results
//            doMySearch(query);
        }
    }

    private boolean doMySearch(String query){
        return myData.contains(query);
    }

}

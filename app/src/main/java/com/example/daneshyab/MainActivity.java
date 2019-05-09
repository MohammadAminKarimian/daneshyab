package com.example.daneshyab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.daneshyab.AccountPage.AccountFragment;
import com.example.daneshyab.CategoryPage.CategoryFragment;
import com.example.daneshyab.HomePage.HomeFragment;
import com.example.daneshyab.SearchPage.SearchFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<HandNote> handNotes = new ArrayList<>();

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private AccountFragment accountFragment;
    private SearchFragment searchFragment;

    public static ArrayList<HandNote> getHandNotes() {
        return handNotes;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(homeFragment);
//                    hideKeyboard();
                    return true;
                case R.id.navigation_category:
                    setFragment(categoryFragment);
                    return true;
                case R.id.navigation_account:
                    setFragment(accountFragment);
                    return true;
                case R.id.navigation_search:
                    setFragment(searchFragment);
//                    showKeyboard();
                    return true;
            }
            return false;
        }
    };

//    private void showKeyboard(){
//        SearchView searchView = findViewById(R.id.search_fragment_search_view);
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);
//    }
//
//    private void hideKeyboard(){
////        View view = getCurrentFocus();
////        SearchView searchView = findViewById(R.id.search_fragment_search_view);
//        if(getCurrentFocus() != null){
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchData();

        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        accountFragment = new AccountFragment();
        searchFragment = new SearchFragment();
        setFragment(homeFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();
    }

    private void fetchData(){
        handNotes.add(new HandNote("مهندسی اینترنت", "فروزش", "شهید چمران", R.color.colorPrimaryLight));
        handNotes.add(new HandNote("ریاضی 2", "کاظمی فر", "شهید چمران", R.color.colorAccent));
        handNotes.add(new HandNote("شیمی", "جعفری", "شهید چمران", R.color.colorPrimaryLight));
        handNotes.add(new HandNote("برنامه نویسی", "صفار زاده", "شهید چمران", R.color.colorAccent));
        handNotes.add(new HandNote("آنالیز عددی", "صالح نژاد", "شهید چمران", R.color.colorPrimaryLight));
        handNotes.add(new HandNote("سیستم عامل", "طاهری", "شهید چمران", R.color.colorAccent));
        handNotes.add(new HandNote("مهندسی اینترنت", "فروزش", "شهید چمران", R.color.colorPrimaryLight));
        handNotes.add(new HandNote("ریاضی 2", "کاظمی فر", "شهید چمران", R.color.colorAccent));
        handNotes.add(new HandNote("برنامه نویسی", "صفار زاده", "شهید چمران", R.color.colorPrimaryLight));
    }

}

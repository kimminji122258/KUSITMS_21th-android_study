package com.example.instalistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    Fragment mainFragment = new MainFragment();
    Fragment searchFragment = new SearchFragment();
    Fragment likeFragment = new LikeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //ListView
        ArrayList<FeedItemData> items = new ArrayList<>();

        FeedItemAdapter feedItemAdapter = new FeedItemAdapter(getApplicationContext(),items);
        ListView feedView = findViewById(R.id.feedView);
        feedView.setAdapter(feedItemAdapter);

        items.add(new FeedItemData(R.drawable.sample1, 3, "첫 번째 피드!"));
        items.add(new FeedItemData(R.drawable.sample2, 4, "두 번째 피드!"));
        items.add(new FeedItemData(R.drawable.sample3, 5, "세 번째 피드!"));

        feedItemAdapter.notifyDataSetChanged();


        fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, mainFragment).commit();

        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.homeNavButton:
                        selectedFragment = mainFragment;
                        break;
                    case R.id.searchNavButton:
                        selectedFragment = searchFragment;
                        break;
                    case R.id.likeNavButton:
                        selectedFragment = likeFragment;
                        break;
                }

                if (selectedFragment != null)
                    fragmentTransaction.replace(R.id.frameLayout, selectedFragment).commit();

                return true;
            }
        });




    }
}

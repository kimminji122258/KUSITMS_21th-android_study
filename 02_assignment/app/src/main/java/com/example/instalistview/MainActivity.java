package com.example.instalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Button roading_btn = findViewById(R.id.roadingButton);

        roading_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //ListView
                ArrayList<FeedItemData> items = new ArrayList<>();

                FeedItemAdapter feedItemAdapter = new FeedItemAdapter(getApplicationContext(),items);
                ListView feedView = findViewById(R.id.feedView);
                feedView.setAdapter(feedItemAdapter);

                items.add(new FeedItemData(R.drawable.sample1, 3, "첫 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample2, 4, "두 번째 피드!"));
                items.add(new FeedItemData(R.drawable.sample3, 5, "세 번째 피드!"));

                feedItemAdapter.notifyDataSetChanged();
            }
        });


    }
}

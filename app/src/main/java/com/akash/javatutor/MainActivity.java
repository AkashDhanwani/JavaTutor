package com.akash.javatutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvChapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvChapters = (ListView) findViewById(R.id.lvChapters);

        ArrayList <String> chapter = new ArrayList<>();
        chapter.add("Chapter 1");
        chapter.add("Chapter 2");
        chapter.add("Chapter 3");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,chapter);

        lvChapters.setAdapter(adapter);

        lvChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(),ChapterActivity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }
}

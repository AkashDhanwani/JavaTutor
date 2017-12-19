package com.akash.javatutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChapterActivity extends AppCompatActivity {

    TextView tvChapterContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        tvChapterContent = (TextView) findViewById(R.id.tvChapterContent);

        Intent i = getIntent();
        int position = i.getIntExtra("position",0);
        String file = (position+1) + ".txt";

        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open(file));
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String message;

            while ((message=br.readLine()) != null)
            {
                sb.append(message + "\n");
            }
            br.close();
            tvChapterContent.setText(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {

    ListView lv;
    Button btnFilter;
    ArrayList<Song> aa;
    SongsArrayAdapter al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = findViewById(R.id.listViewSongs);
        btnFilter = (Button) findViewById(R.id.buttonFilter);
        DBHelper db = new DBHelper(ShowSongActivity.this);
        aa = db.getAllSongs();
        al = new SongsArrayAdapter(ShowSongActivity.this, R.layout.row, aa);
        lv.setAdapter(al);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
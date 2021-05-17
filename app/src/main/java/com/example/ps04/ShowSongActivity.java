package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Song> aa;
    SongsArrayAdapter al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = findViewById(R.id.listViewSongs);

        DBHelper db = new DBHelper(ShowSongActivity.this);
        aa = db.getAllSongs();
        al = new SongsArrayAdapter(ShowSongActivity.this, R.layout.row, aa);
        lv.setAdapter(al);
    }
}
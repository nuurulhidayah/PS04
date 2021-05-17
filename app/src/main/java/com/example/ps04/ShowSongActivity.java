package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Song> al;
    SongsArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = findViewById(R.id.listViewSongs);

        al = new ArrayList<Song>();

        DBHelper db = new DBHelper(ShowSongActivity.this);

        ArrayList<Song> arrayList = db.getAllSongs();
        al.addAll(arrayList);
        db.close();

        aa = new SongsArrayAdapter(ShowSongActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

    }
}
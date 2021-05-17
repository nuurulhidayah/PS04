package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        al.addAll(db.getAllSongs());
        db.close();

        aa = new SongsArrayAdapter(ShowSongActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song target = al.get(position);
                Intent i = new Intent(ShowSongActivity.this,
                        ModifySongActivity.class);
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            aa.notifyDataSetChanged();

            DBHelper db = new DBHelper(ShowSongActivity.this);
            al.clear();
            al.addAll(db.getAllSongs());
        }
    }
}
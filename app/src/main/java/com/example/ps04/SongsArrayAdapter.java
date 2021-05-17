package com.example.ps04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongsArrayAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;
    TextView tvYear, tvSinger, tvTitle;

    public SongsArrayAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);
        iv1 = (ImageView) rowView.findViewById(R.id.imageView2);
        iv2 = (ImageView) rowView.findViewById(R.id.imageView3);
        iv3 = (ImageView) rowView.findViewById(R.id.imageView4);
        iv4 = (ImageView) rowView.findViewById(R.id.imageView5);
        iv5 = (ImageView) rowView.findViewById(R.id.imageView6);

        tvYear = (TextView) rowView.findViewById(R.id.textViewYear3);
        tvSinger = (TextView) rowView.findViewById(R.id.textViewSinger3);
        tvTitle = (TextView) rowView.findViewById(R.id.textViewTitle3);

        Song song = songs.get(position);

        tvYear.setText(song.getYear());
        tvSinger.setText(song.getSinger());
        tvTitle.setText(song.getTitle());

        //Check if the property for stars >= 5, if so, "light" up the stars
        if (song.getStars() >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStars() == 4){
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStars() == 3){
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStars() == 2){
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStars() == 1){
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_off);
        }


        return super.getView(position, convertView, parent);
    }
}

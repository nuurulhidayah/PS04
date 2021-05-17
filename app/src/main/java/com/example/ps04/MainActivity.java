package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShow;
    RadioGroup rg;
    RadioButton rgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) this.findViewById(R.id.editTextTitle);
        etSinger = (EditText) this.findViewById(R.id.editTextSinger);
        etYear = (EditText) this.findViewById(R.id.editTextYear);
        btnInsert = (Button) this.findViewById(R.id.buttonInsert);
        btnShow = (Button) this.findViewById(R.id.buttonShowList);

        rg = (RadioGroup) this.findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the
                //activity's context
                DBHelper db = new DBHelper(MainActivity.this);

                String title = "";

                if (etTitle.getText().toString().equalsIgnoreCase("")){
                    etTitle.setError("Please enter title");
                } else {
                    title = etTitle.getText().toString();
                }

                String singer = "";

                if (etSinger.getText().toString().equalsIgnoreCase("")){
                    etSinger.setError("Please enter singer");
                } else {
                    singer = etSinger.getText().toString();
                }

                int year = 0;

                if (etYear.getText().toString().equalsIgnoreCase("")){
                    etYear.setError("Please enter year");
                } else {
                    year = Integer.parseInt(etYear.getText().toString());
                }

                if (!(title.equals("") || singer.equals("") || year == 0)){
                    //Insert a task
                    int selectedId = rg.getCheckedRadioButtonId();
                    rgBtn = (RadioButton) findViewById(selectedId);
                    String number = rgBtn.getText().toString();
                    int num = Integer.parseInt(number);
                    db.insertSong(title, singer, year, num);
                    db.close();

                    Toast.makeText(MainActivity.this, "Inserted",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                DBHelper db = new DBHelper(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, ShowSongActivity.class);
                startActivity(intent);
            }
        });

    }
}
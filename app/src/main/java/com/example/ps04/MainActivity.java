package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) this.findViewById(R.id.editTextTitle);
        etSinger = (EditText) this.findViewById(R.id.editTextSinger);
        etYear = (EditText) this.findViewById(R.id.editTextYear);
        btnInsert = (Button) this.findViewById(R.id.buttonInsert);
        btnShow = (Button) this.findViewById(R.id.buttonShowList);

    }
}
package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ModifySongActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle2, etSinger2, etYear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        etTitle2 = (EditText) this.findViewById(R.id.editTextTitle2);
        etSinger2 = (EditText) this.findViewById(R.id.editTextSinger2);
        etYear2 = (EditText) this.findViewById(R.id.editTextYear2);
        btnUpdate = (Button) this.findViewById(R.id.buttonUpdate);
        btnDelete = (Button) this.findViewById(R.id.buttonDelete);
        btnCancel = (Button) this.findViewById(R.id.buttonCancel);

    }
}
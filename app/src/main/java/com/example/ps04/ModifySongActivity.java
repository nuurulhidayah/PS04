package com.example.ps04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ModifySongActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle2, etSinger2, etYear2;
    TextView tvID;
    RadioGroup rg;
    RadioButton rgBtn, b;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvID = (TextView) this.findViewById(R.id.tvID);
        etTitle2 = (EditText) this.findViewById(R.id.editTextTitle2);
        etSinger2 = (EditText) this.findViewById(R.id.editTextSinger2);
        etYear2 = (EditText) this.findViewById(R.id.editTextYear2);

        btnUpdate = (Button) this.findViewById(R.id.buttonUpdate);
        btnDelete = (Button) this.findViewById(R.id.buttonDelete);
        btnCancel = (Button) this.findViewById(R.id.buttonCancel);

        rg = (RadioGroup) this.findViewById(R.id.rg);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvID.setText("" + data.get_id());
        etTitle2.setText(data.getTitle());
        etSinger2.setText(data.getSinger());
        etYear2.setText("" + data.getYear());

        int selected = data.getStars();

        if (selected == 1){
            b = (RadioButton) findViewById(R.id.radioButton1);
        } else if (selected == 2){
            b = (RadioButton) findViewById(R.id.radioButton2);
        } else if (selected == 3){
            b = (RadioButton) findViewById(R.id.radioButton3);
        } else if (selected == 4){
            b = (RadioButton) findViewById(R.id.radioButton4);
        } else {
            b = (RadioButton) findViewById(R.id.radioButton5);
        }
        b.setChecked(true);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySongActivity.this);
                data.setTitle(etTitle2.getText().toString());
                data.setSinger(etSinger2.getText().toString());
                data.setYear(Integer.parseInt(etYear2.getText().toString()));

                int selectedId = rg.getCheckedRadioButtonId();
                rgBtn = (RadioButton) findViewById(selectedId);
                String number = rgBtn.getText().toString();
                int num = Integer.parseInt(number);
                data.setStars(num);

                dbh.updateSong(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySongActivity.this);
                dbh.deleteSong(data.get_id());
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
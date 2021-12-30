package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    public Spinner spinner;
    EditText editTextTextPersonName;
    ImageView imgTraslate;
    int type=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        spinner = findViewById(R.id.spinner);
        editTextTextPersonName= (EditText) findViewById(R.id.editTextTextPersonName);
        imgTraslate= (ImageView) findViewById(R.id.imgTraslate);
        ArrayList<String> List = new ArrayList<>();
        List.add("English to Persian");
        List.add("Persian to English");



        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,List);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(SecondActivity.this,"you Choosed : " +  spinner.getSelectedItem().toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        imgTraslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ResultActivity.class);
                if(spinner.getSelectedItem().toString().equals("English to Persian")){

                    type=0;

                }
                else {
                    type=1;
                }
                intent.putExtra("text",editTextTextPersonName.getText().toString());
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }

}
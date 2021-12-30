package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myproject.api.ApiServices;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    ImageView back;
    TextView tvTitle;
    EditText edtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvTitle= (TextView)  findViewById(R.id.tvTitle);
        edtResult= (EditText)  findViewById(R.id.edtResult);

        String txt= getIntent().getExtras().getString("text");
        int type= getIntent().getExtras().getInt("type");
        tvTitle.setText(txt);

        if (type==0){

            ApiServices api = new ApiServices(ResultActivity.this);
            api.EnglishToFarsi(txt, new ApiServices.OnReciveWithOject() {
                @Override
                public void onSuc(JSONObject jsons) {

                    try {
                        JSONObject data=  jsons.getJSONObject("data");

                        Log.d("data ", data.toString());
                        edtResult.setText(data.getJSONArray("results").getJSONObject(0).getString("text"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onError(String msg) {

                }
            });
        }
        else {

            ApiServices api = new ApiServices(ResultActivity.this);
            api.FarsiToEnglish(txt, new ApiServices.OnReciveWithOject() {
                @Override
                public void onSuc(JSONObject jsons) {

                    try {
                        JSONObject data=  jsons.getJSONObject("data");

                        Log.d("data ", data.toString());
                        edtResult.setText(data.getJSONArray("results").getJSONObject(0).getString("text"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onError(String msg) {

                }
            });


        }




    }
    public  void back(View view){
        finish();
    }
}
package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SD_2F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_2_f);
    }

    public void upTo3F(View v){
        Intent it = new Intent(this, SD_3F.class);
        startActivity(it);
    }

    public void downTo1F(View v){
        Intent it = new Intent(this, SD_1F.class);
        startActivity(it);
    }

    public void toSC_2F(View v){
        Intent it = new Intent(this, SC_2F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

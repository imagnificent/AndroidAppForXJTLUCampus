package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SC_2F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc_2_f);
    }

    public void upTo3F(View v){
        Intent it = new Intent(this, SC_3F.class);
        startActivity(it);
    }

    public void downTo1F(View v){
        Intent it = new Intent(this, SC_1F.class);
        startActivity(it);
    }

    public void toSD_2F(View v){
        Intent it = new Intent(this, SD_2F.class);
        startActivity(it);
    }

    public void toSB_2F(View v){
        Intent it = new Intent(this, SB_2F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

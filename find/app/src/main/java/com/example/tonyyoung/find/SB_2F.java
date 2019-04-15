package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SB_2F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sb_2_f);
    }

    public void upTo3F(View v){
        Intent it = new Intent(this, SB_3F.class);
        startActivity(it);
    }

    public void downTo1F(View v){
        Intent it = new Intent(this, SB_1F.class);
        startActivity(it);
    }

    public void toSC_2F(View v){
        Intent it = new Intent(this, SC_2F.class);
        startActivity(it);
    }

    public void toSA_2F(View v){
        Intent it = new Intent(this, SA_2F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

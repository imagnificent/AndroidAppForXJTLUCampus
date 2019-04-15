package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CB_10F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_10_f);
    }

    public void goBackToGeneral(View v){ finish(); }

    public void downTo9F(View v){
        Intent it = new Intent(this, CB_9F.class);
        startActivity(it);
    }

    public void cb1014(View v){
        Intent it = new Intent(this, CB714.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_10f_msgWall.class);
        startActivity(it);
    }
}

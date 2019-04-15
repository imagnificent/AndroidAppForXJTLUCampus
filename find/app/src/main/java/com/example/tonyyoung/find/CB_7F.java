package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CB_7F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_7_f);
    }

    public void goBackToGeneral(View v){ finish(); }

    public void upTo8F(View v){
        Intent it = new Intent(this, CB_8F.class);
        startActivity(it);
    }

    public void downTo6F(View v){
        Intent it = new Intent(this, CB_6F.class);
        startActivity(it);
    }

    public void cb714(View v){
        Intent it = new Intent(this, CB714.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_7f_msgWall.class);
        startActivity(it);
    }


}

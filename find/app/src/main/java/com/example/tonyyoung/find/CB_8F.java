package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CB_8F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_8_f);
    }

    public void goBackToGeneral(View v){ finish(); }

    public void upTo9F(View v){
        Intent it = new Intent(this, CB_9F.class);
        startActivity(it);
    }

    public void downTo7F(View v){
        Intent it = new Intent(this, CB_7F.class);
        startActivity(it);
    }

    public void cb814(View v){
        Intent it = new Intent(this, CB814.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_8f_msgWall.class);
        startActivity(it);
    }

}

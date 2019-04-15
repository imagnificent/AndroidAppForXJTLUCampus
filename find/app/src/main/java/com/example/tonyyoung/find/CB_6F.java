package com.example.tonyyoung.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CB_6F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_6_f);
    }

    public void goBackToGeneral(View v){ finish(); }

    public void upTo7F(View v){
        Intent it = new Intent(this, CB_7F.class);
        startActivity(it);
    }

    public void downTo5F(View v){
        Intent it = new Intent(this, CB_5F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_6f_msgWall.class);
        startActivity(it);
    }
}

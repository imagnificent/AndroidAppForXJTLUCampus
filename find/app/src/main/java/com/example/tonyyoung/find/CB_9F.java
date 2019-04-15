package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CB_9F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_9_f);
    }

    public void goBackToGeneral(View v){ finish(); }

    public void upTo10F(View v){
        Intent it = new Intent(this, CB_10F.class);
        startActivity(it);
    }

    public void downTo8F(View v){
        Intent it = new Intent(this, CB_8F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_9f_msgWall.class);
        startActivity(it);
    }
}

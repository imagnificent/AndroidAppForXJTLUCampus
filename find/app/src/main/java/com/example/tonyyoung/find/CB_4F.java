package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//implements View.OnClickListener

public class CB_4F extends AppCompatActivity {

    //int[] cb4f_buttons_Id = {R.id.book429, R.id.book445, R.id.cb4to3, R.id.cb4to5, R.id.cb4downto3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_4_f);

        /*
        for (int id:cb4f_buttons_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
        }
        */
    }

    public void upTo5F(View v){
        Intent it = new Intent(this, CB_5F.class);
        startActivity(it);
    }

    public void downTo3F(View v){
        Intent it = new Intent(this, CB_3F.class);
        startActivity(it);
    }

    public void cb429(View v){
        Intent it = new Intent(this, CB429.class);
        startActivity(it);
    }

    public void cb445(View v){
        Intent it = new Intent(this, CB445.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_4f_msgWall.class);
        startActivity(it);
    }


    /*
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.book429:
                Intent it = new Intent(this, CB429.class);
                startActivity(it);
                break;

            case R.id.book445:
                Intent it2 = new Intent(this, CB445.class);
                startActivity(it2);
                break;

            case R.id.cb4to3:
                Intent it3 = new Intent(this, CB_3F.class);
                startActivity(it3);
                break;

            case R.id.cb4to5:
                Intent it4 = new Intent(this, CB_5F.class);
                startActivity(it4);
                break;

            case R.id.cb4downto3:
                Intent it5 = new Intent(this, CB_3F.class);
                startActivity(it5);
                break;
        }
    }
    */
}

package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//implements View.OnClickListener

public class CB_3F extends AppCompatActivity {

    int[] cb3f_buttons_Id = {R.id.book314, R.id.book316, R.id.book318, R.id.cb3to4, R.id.cb3upto4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_3_f);

        /*
        for (int id: cb3f_buttons_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
        }
        */
    }

    public void upTo4F(View v){
        Intent it = new Intent(this, CB_4F.class);
        startActivity(it);
    }

    public void cb314(View v){
        Intent it = new Intent(this, CB314.class);
        startActivity(it);
    }

    public void cb316(View v){
        Intent it = new Intent(this, CB316.class);
        startActivity(it);
    }

    public void cb318(View v){
        Intent it = new Intent(this, CB318.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_3f_msgWall.class);
        startActivity(it);
    }


/*
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.book314:
                Intent it = new Intent(this, CB314.class);
                startActivity(it);
                break;

            case R.id.book316:
                Intent it2 = new Intent(this, CB316.class);
                startActivity(it2);
                break;

            case R.id.book318:
                Intent it3 = new Intent(this, CB318.class);
                startActivity(it3);
                break;

            case R.id.cb3to4:
                Intent it4 = new Intent(this, CB_4F.class);
                startActivity(it4);
                break;

            case R.id.cb3upto4:
                Intent it5 = new Intent(this, CB_4F.class);
                startActivity(it5);
                break;
        }
    }
    */
}

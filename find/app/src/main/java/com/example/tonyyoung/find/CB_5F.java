package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//View.OnClickListener

public class CB_5F extends AppCompatActivity {

    //int[] cb5f_buttons_Id = {R.id.book547, R.id.cb5to4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_5_f);

        /*
        for (int id:cb5f_buttons_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
        }
        */
    }


    public void upTo6F(View v){
        Intent it = new Intent(this, CB_6F.class);
        startActivity(it);
    }

    public void downTo4F(View v){
        Intent it = new Intent(this, CB_4F.class);
        startActivity(it);
    }

    public void cb545(View v){
        Intent it = new Intent(this, CB545.class);
        startActivity(it);
    }

    public void cb547(View v){
        Intent it = new Intent(this, CB547.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void msgWall(View v){
        Intent it = new Intent(this, cb_5f_msgWall.class);
        startActivity(it);
    }
}

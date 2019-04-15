package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CB_General extends AppCompatActivity implements View.OnClickListener {

    int[] cb_buttons_Id = {R.id.cb_3f_button, R.id.cb_4f_button,R.id.cb_5f_button, R.id.cb_6f_button,
            R.id.cb_7f_button, R.id.cb_8f_button,R.id.cb_9f_button, R.id.cb_10f_button};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb__general);

        for (int id:cb_buttons_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.cb_3f_button:
                Intent it = new Intent(this, CB_3F.class);
                startActivity(it);
                break;

            case R.id.cb_4f_button:
                Intent it2 = new Intent(this, CB_4F.class);
                startActivity(it2);
                break;

            case R.id.cb_5f_button:
                Intent it3 = new Intent(this, CB_5F.class);
                startActivity(it3);
                break;

            case R.id.cb_6f_button:
                Intent it4 = new Intent(this, CB_6F.class);
                startActivity(it4);
                break;

            case R.id.cb_7f_button:
                Intent it5 = new Intent(this, CB_7F.class);
                startActivity(it5);
                break;

            case R.id.cb_8f_button:
                Intent it6 = new Intent(this, CB_8F.class);
                startActivity(it6);
                break;

            case R.id.cb_9f_button:
                Intent it7 = new Intent(this, CB_9F.class);
                startActivity(it7);
                break;

            case R.id.cb_10f_button:
                Intent it8 = new Intent(this, CB_10F.class);
                startActivity(it8);
                break;
        }
    }
}

package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SA_3F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa_3_f);
    }

    public void upTo4F(View v){
        Intent it = new Intent(this, SA_4F.class);
        startActivity(it);
    }

    public void downTo2F(View v){
        Intent it = new Intent(this, SA_2F.class);
        startActivity(it);
    }

    public void toSB_3F(View v){
        Intent it = new Intent(this, SB_3F.class);
        startActivity(it);
    }

    public void backToMain(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}

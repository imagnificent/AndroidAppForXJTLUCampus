package com.example.tonyyoung.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SA_General extends AppCompatActivity implements View.OnClickListener {

    int[] button_Id = {R.id.sa_1f_btn, R.id.sa_2f_btn, R.id.sa_3f_btn, R.id.sa_4f_btn, R.id.sa_5f_btn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa__general);

        for (int id:button_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sa_1f_btn:
                Intent it = new Intent(this, SA_1F.class);
                startActivity(it);
                break;

            case R.id.sa_2f_btn:
                Intent it2 = new Intent(this, SA_2F.class);
                startActivity(it2);
                break;

            case R.id.sa_3f_btn:
                Intent it3 = new Intent(this, SA_3F.class);
                startActivity(it3);
                break;

            case R.id.sa_4f_btn:
                Intent it4 = new Intent(this, SA_4F.class);
                startActivity(it4);
                break;

            case R.id.sa_5f_btn:
                Intent it5 = new Intent(this, SA_5F.class);
                startActivity(it5);
                break;
        }
    }

    public void msgWall(View v){
        Intent it = new Intent(this, sa_msgWall.class);
        startActivity(it);
    }
}

package com.example.tonyyoung.find;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CB1014 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb1014);
    }

    public void goBackTo10F(View v){ finish(); }

    public void bookThisRoom(View v){
        Uri uri = Uri.parse("http://bookings.lib.xjtlu.edu.cn/ClientWeb/xcus/ic2/Default.aspx");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

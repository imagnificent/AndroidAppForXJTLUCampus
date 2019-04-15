package com.example.tonyyoung.find;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    int[] button_Id = {R.id.fb_button, R.id.cb_button, R.id.sa_button, R.id.sb_button,
            R.id.sc_button, R.id.sd_button, R.id.searchBookButton, R.id.loginButton, R.id.campusMapButton,
            R.id.bookRoomButton, R.id.myAccountButton, R.id.getInfoButton};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int id:button_Id){
            ((Button)findViewById(id)).setOnClickListener(this);
            ((Button)findViewById(id)).setOnLongClickListener(this);
        }

        ((TextView)findViewById(R.id.display)).setOnLongClickListener(this);
        ((Button)findViewById(R.id.searchBookButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.loginButton)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.cb_button:
                Intent it = new Intent(this, CB_General.class);
                startActivity(it);
                break;

            case R.id.sa_button:
                Intent it2 = new Intent(this, SA_General.class);
                startActivity(it2);
                break;

            case R.id.sb_button:
                Intent it3 = new Intent(this, SB_General.class);
                startActivity(it3);
                break;

            case R.id.sc_button:
                Intent it4 = new Intent(this, SC_General.class);
                startActivity(it4);
                break;

            case R.id.sd_button:
                Intent it5 = new Intent(this, SD_General.class);
                startActivity(it5);
                break;

            case R.id.searchBookButton:
                Intent it6 = new Intent(this, searchBook.class);
                startActivity(it6);
                break;

            case R.id.myAccountButton:
                Intent it7 = new Intent(this, Login.class);
                startActivity(it7);
                break;

            case R.id.campusMapButton:
                Intent it8 = new Intent(this, campusMap.class);
                startActivity(it8);
                break;

            case R.id.getInfoButton:
                Intent it9 = new Intent(this, infor.class);
                startActivity(it9);
                break;

            case R.id.bookRoomButton:
                Intent it10 = new Intent(this, room_booking.class);
                startActivity(it10);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        ScrollView sv = (ScrollView)findViewById(R.id.displayScrolView);
        TextView building_info_display = (TextView)findViewById(R.id.display);

        switch(v.getId()){
            case R.id.fb_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("FB is short for 'Foundation Building', which is often open for 24H. Students often have classes in this building. \n\n" +
                        "There are 6 floors of this building. Freshmen usually have their EAP and Mathematics class in FB. \n\n" +
                        "You can find some tutors' offices from 4f to 6f. Meanwhile, you can also find computer room on 5F. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.cb_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("CB is short for 'Central Building'. This building contains campus library and some management staff office. \n\n" +
                        "There are 10 floors of the library part. You can find a place for self-study on any floor. Also you can borrow any books you like. Library usually open from 8AM-10PM. \n\n" +
                        "If you want to go management staff area (just like academic office and financial office), take the elevator on the east side of CB. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.sa_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("SA is short for 'Science Building A', which is often open for 24H. Students often have classes in this building. \n\n" +
                        "The ground floor of SA is often used for freshman modules which require large space. \n\n" +
                        "There are 5 floors in this building. SA is largely for department of Chemistry. Usually you can find tutors' offices from 3f to 5f. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.sb_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("SB is short for 'Science Building B', which is often open for 24H. Students often have classes in this building. \n\n" +
                        "The ground floor of SB is often used for freshman modules which require large space. \n\n" +
                        "There are 5 floors in this building. SB is largely for department of biology. Usually you can find tutors' offices from 3f to 5f. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.sc_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("SC is short for 'Science Building C', which is often open for 24H. Students often have classes in this building. \n\n" +
                        "The ground floor of SC is often used for freshman modules which require large space. \n\n" +
                        "There are 5 floors in this building. SC is largely for research laboratories. Usually you can find tutors' offices from 3f to 5f. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.sd_button:
                sv.setVisibility(View.VISIBLE);
                building_info_display.setText("SD is short for 'Science Building D', which is often open for 24H. Students often have classes in this building. \n\n" +
                        "The ground floor of SD is often used for freshman modules which require large space. \n\n" +
                        "There are 5 floors in this building. SD is largely for department of computer science. Usually you can find tutors' offices from 3f to 5f. \n\n "  +
                        "[Press this billboard for 2 seconds if you want to exit~] \n");
                break;

            case R.id.display:
                sv.setVisibility(View.GONE);
                break;

        }
        return true;
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_NO_ANIMATION);
        return intent;
    }

}

package com.example.tonyyoung.find;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class room_booking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner Building, Room;
    TextView txv;

    String[] sa_room_set = {"SA169", "SA164", "SA136", "SA236", "SA332", "SA361"};
    String[] sb_room_set = {"SB152", "SB123", "SB120", "SB102", "SB230", "SB220", "SB252", "SB336", "SB352"};
    String[] sc_room_set = {"SC169", "SC162", "SC176", "SC140", "SC236", "SC262", "SC336", "SC354"};
    String[] sd_room_set = {"SD154", "SD102", "SD114", "SD120", "SD220", "SD214", "SD254", "SD354", "SD334"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_booking);

        txv = (TextView) findViewById(R.id.txv);

        Building = (Spinner) findViewById(R.id.Building);

        Room = (Spinner) findViewById(R.id.Room);

        Building.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] the_room_set = new String[0];
        if (position == 0){
            the_room_set = sa_room_set;
        }else if (position == 1){
            the_room_set = sb_room_set;
        }else if (position == 2){
            the_room_set = sc_room_set;
        }else if (position == 3){
            the_room_set = sd_room_set;
        }

        ArrayAdapter<String> R = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, the_room_set);
        R.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Room.setAdapter(R);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void display(View v) {
        String msg = Building.getSelectedItem() + ", " + Room.getSelectedItem();
        txv.setText(msg);
    }
}

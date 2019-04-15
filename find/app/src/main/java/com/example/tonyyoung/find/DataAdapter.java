package com.example.tonyyoung.find;

import java.util.List;
import java.util.zip.Inflater;

import com.example.tonyyoung.find.postMessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter{

    private List<postMessage> messages;
    private Context context;

    private TextView v_content;
    private TextView v_time;
    private TextView v_uper;
    private TextView v_location;

    public DataAdapter(List<postMessage> messages, Context context){
        this.messages = messages;
        this.context = context;
    }

    public int getCount() {
        return messages.size();
    }

    public Object getItem(int arg0) {
        return messages.get(arg0);
    }

    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    public View getView(int arg0, View arg1, ViewGroup arg2) {

        RelativeLayout layout = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.list_message, null);
        postMessage msg = (postMessage)getItem(arg0);


        v_content = (TextView)layout.findViewById(R.id.Content);
        v_time = (TextView)layout.findViewById(R.id.CreateTime);
        v_uper = (TextView)layout.findViewById(R.id.Meassger);
        v_location = (TextView)layout.findViewById(R.id.Location);

        v_content.setText(msg.getContent());
        v_time.setText(msg.getTime());
        v_uper.setText(msg.getUper());
        v_location.setText(msg.getLocation());

        return layout;
    }

}

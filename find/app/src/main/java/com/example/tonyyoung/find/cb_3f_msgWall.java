package com.example.tonyyoung.find;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class cb_3f_msgWall extends AppCompatActivity {

    private List<postMessage> messages = new ArrayList<postMessage>();
    private DataAdapter myAdapter;
    private Handler handler;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cb_3f_msg_wall);
        listView = (ListView) findViewById(R.id.listView);

        handler = new Handler() {

            public void handleMessage(android.os.Message msg) {
                if (msg.what == 0x123) {
                    System.out.println("Receive");
                    for (postMessage g : messages) {
                        System.out.println(g.getContent());
                    }
                    myAdapter = new DataAdapter(messages, cb_3f_msgWall.this);
                    listView.setAdapter(myAdapter);
                }
            }

            ;

        };
        attemptGet();
    }

    private void attemptGet() {
        new Thread(new getHandler()).start();

    }
    public class getHandler implements Runnable {
        @Override
        public void run() {

            final String data = WebService.executeHttpGet("MessageServlet","cb_3f_msgWall", "any");
            messages = parseJSONWithGSON(data);
            final Message handlerMsg = new Message();
            handlerMsg.what = 0x123;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    handler.sendMessage(handlerMsg);
                }
            });
        }
    }

    private ArrayList<postMessage> parseJSONWithGSON(String jsonData) {
        ArrayList<postMessage> receiveMessages = null;
        Gson gson = new Gson();
        postMessage m = gson.fromJson(jsonData, postMessage.class);
        if ( m != null) {
            receiveMessages.add(m);
        }
        return receiveMessages;
    }

}

package com.chat.cstmbrodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Popup extends AppCompatActivity {
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        textView1 = findViewById(R.id.textView);
        textView1.setText("this is pop up");

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels, width = displayMetrics.widthPixels;
        getWindow().setLayout((int) (height * .5), (int) (width * .8));

        ShowData();
        /*IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("customBrodcast");
        MyReceiver myReceiver= new MyReceiver();
        registerReceiver(myReceiver,intentFilter);*/
    }

    public void ShowData(){
        DbHelper dbHelper= new DbHelper(this);
        Cursor cursor= dbHelper.DisplayData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                String s= cursor.getString(1);
                String s1= cursor.getString(2);
                String s2= cursor.getString(3);
                textView1.setText(s+"\n"+s1+"\n"+s2);
            }
        }
        cursor.close();
        dbHelper.close();
    }

    /*public BroadcastReceiver broadcastReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive (Context context, Intent intent){
            String s = intent.getStringExtra("name");
            String s1 = intent.getStringExtra("home");
            String s2 = intent.getStringExtra("occu");
            textView1.setText(s);
            Toast.makeText(context, "successfully", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        try {
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("customBrodcast");
        registerReceiver(broadcastReceiver , filter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("customBrodcast");
        registerReceiver(broadcastReceiver , filter);
    }*/
}

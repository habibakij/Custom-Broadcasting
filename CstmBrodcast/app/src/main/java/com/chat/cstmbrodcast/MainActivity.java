package com.chat.cstmbrodcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button brodCast;
    private EditText name, homeDistrict, occupation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //brodCast= findViewById(R.id.sendBrodcast);
        name= findViewById(R.id.name);
        homeDistrict= findViewById(R.id.homedis);
        occupation= findViewById(R.id.occupaton);
    }

    public void CustomBrodcast(View view) {
        String Name= name.getText().toString();
        String HomeDistrict= homeDistrict.getText().toString();
        String Occupation= occupation.getText().toString();

        Intent intent= new Intent("customBrodcast");
        intent.putExtra("name",Name);
        intent.putExtra("homeDistrict",HomeDistrict);
        intent.putExtra("occupation",Occupation);
        sendBroadcast(intent);

        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("customBrodcast");
        MyReceiver popup= new MyReceiver();
        registerReceiver(popup,intentFilter);

        startActivity(new Intent(MainActivity.this, Popup.class));
        name.setText("");
        homeDistrict.setText("");
        occupation.setText("");
    }

    /*private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String s= intent.getStringExtra("name");
            String s1= intent.getStringExtra("homeDistrict");
            String s2= intent.getStringExtra("occupation");
            textView.setText(s+"\n"+s1+"\n"+s2);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        try {
            if(broadcastReceiver != null){
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
    }*/
}

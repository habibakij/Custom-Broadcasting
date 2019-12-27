package com.chat.cstmbrodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s= intent.getStringExtra("name");
        String s1= intent.getStringExtra("homeDistrict");
        String s2= intent.getStringExtra("occupation");
        //Toast.makeText(context, "data is: "+s+"\n"+s1+"\n"+s2, Toast.LENGTH_SHORT).show();

        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
        dbHelper.SaveData(s,s1,s2, sqLiteDatabase);
        dbHelper.close();
    }
}

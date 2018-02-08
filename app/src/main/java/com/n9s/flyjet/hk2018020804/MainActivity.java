package com.n9s.flyjet.hk2018020804;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReceiver();    // 建立廣播接收元件物件
    }

    public void click1(View v)
    {
        IntentFilter filter = new IntentFilter();
        //filter.addAction("myaction");
        filter.addAction(Intent.ACTION_SCREEN_ON); //監聽螢幕打開
        // 準備註冊與移除廣播接收元件的IntentFilter物件
        filter.setPriority(500);       //優先權, 越高越優先
        registerReceiver(receiver, filter); // 註冊廣播接收元件
    }

    public void click2(View v)
    {
        unregisterReceiver(receiver);   // 移除廣播接收元件
    }

    public void click3(View v)
    {
        Intent intent = new Intent("myaction");
        sendBroadcast(intent);
    }

}

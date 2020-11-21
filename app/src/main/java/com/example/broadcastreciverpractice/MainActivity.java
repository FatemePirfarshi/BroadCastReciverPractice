package com.example.broadcastreciverpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcastreciverpractice.reciever.CallReceiver;
import com.example.broadcastreciverpractice.reciever.ScreenReceiver;
import com.example.broadcastreciverpractice.reciever.SmsReceiver;
import com.example.broadcastreciverpractice.reciever.WifiReceiver;
import com.example.broadcastreciverpractice.repository.EventDBRepository;

public class MainActivity extends AppCompatActivity {
    private TextView mText;
    private EventDBRepository mRepository;

    private CallReceiver mCallReceiver;
    private ScreenReceiver mScreenReceiver;
    private SmsReceiver mSmsReceiver;
    private WifiReceiver mWifiReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCallReceiver = new CallReceiver();
        mScreenReceiver = new ScreenReceiver();
        mSmsReceiver = new SmsReceiver();
        mWifiReceiver = new WifiReceiver();

        mRepository = EventDBRepository.getInstance(this);
        mText = findViewById(R.id.txt_mode);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilterScreen = new IntentFilter();
        intentFilterScreen.addAction(Intent.ACTION_SCREEN_ON);
        intentFilterScreen.addAction(Intent.ACTION_SCREEN_OFF);
        this.registerReceiver(mScreenReceiver, intentFilterScreen);
        
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(mScreenReceiver);
    }
}
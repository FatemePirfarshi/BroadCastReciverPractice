package com.example.broadcastreciverpractice.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.broadcastreciverpractice.repository.EventDBRepository;

public class WifiReceiver extends BroadcastReceiver {
    private EventDBRepository mRepository;
    @Override
    public void onReceive(Context context, Intent intent) {
        mRepository = EventDBRepository.getInstance(context);

    }
}

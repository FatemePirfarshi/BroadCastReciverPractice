package com.example.broadcastreciverpractice.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.broadcastreciverpractice.model.Event;
import com.example.broadcastreciverpractice.repository.EventDBRepository;

public class SmsReceiver extends BroadcastReceiver {

    private EventDBRepository mRepository;

    @Override
    public void onReceive(Context context, Intent intent) {
        mRepository = EventDBRepository.getInstance(context);
        Event event = new Event("SMS", "In");
        mRepository.insertEvent(event);
    }
}
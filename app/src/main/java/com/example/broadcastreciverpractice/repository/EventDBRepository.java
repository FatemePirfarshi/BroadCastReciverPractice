package com.example.broadcastreciverpractice.repository;

import android.content.Context;

import androidx.room.Room;

import com.example.broadcastreciverpractice.database.EventDatabase;
import com.example.broadcastreciverpractice.database.EventDatabaseDAO;
import com.example.broadcastreciverpractice.model.Event;

import java.util.List;

public class EventDBRepository implements EventDatabaseDAO {

    private static EventDBRepository sInstance;
    private Context mContext;
    private EventDatabaseDAO mEventDAO;

    public static EventDBRepository getInstance(Context context){
        if(sInstance == null)
            sInstance = new EventDBRepository(context);

        return sInstance;
    }

    private EventDBRepository(Context context) {
        mContext = context.getApplicationContext();

        EventDatabase eventDatabase = Room.databaseBuilder(
                mContext, EventDatabase.class, "event.db")
                .allowMainThreadQueries()
                .build();

        mEventDAO = eventDatabase.getEventDAO();
    }

    @Override
    public void insertEvent(Event event) {
        mEventDAO.insertEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {
        mEventDAO.deleteEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        mEventDAO.updateEvent(event);
    }

    @Override
    public List<Event> getEvents() {
        return mEventDAO.getEvents();
    }

    @Override
    public Event getEvent(int id) {
        return mEventDAO.getEvent(id);
    }
}

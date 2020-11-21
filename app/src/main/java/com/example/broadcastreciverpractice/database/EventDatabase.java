package com.example.broadcastreciverpractice.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.broadcastreciverpractice.model.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDatabaseDAO getEventDAO();
}

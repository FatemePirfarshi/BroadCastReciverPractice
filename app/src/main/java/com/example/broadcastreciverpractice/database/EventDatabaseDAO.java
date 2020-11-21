package com.example.broadcastreciverpractice.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.broadcastreciverpractice.model.Event;

import java.util.List;

@Dao
public interface EventDatabaseDAO {

    @Insert
    void insertEvent(Event event);

    @Delete
    void deleteEvent(Event event);

    @Update
    void updateEvent(Event event);

    @Query("SELECT * FROM eventTable")
    List<Event> getEvents();

    @Query("SELECT * FROM eventTable WHERE eventId = :id")
    Event getEvent(int id);
}

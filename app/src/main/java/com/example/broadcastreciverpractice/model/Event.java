package com.example.broadcastreciverpractice.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "eventTable")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "eventId")
    private int mId;

    @ColumnInfo(name = "eventMode")
    private String mEventMode;

    @ColumnInfo(name = "type")
    private String mType;

    @ColumnInfo(name = "timeStamp")
    private Long mTimeStamp;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getEventMode() {
        return mEventMode;
    }

    public void setEventMode(String eventMode) {
        mEventMode = eventMode;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        mTimeStamp = timeStamp;
    }

    public Event(String eventMode, String type) {
        Date date = new Date();
        mEventMode = eventMode;
        mType = type;
        mTimeStamp = date.getTime();
    }
}

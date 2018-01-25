package com.foursquare.takehome;

import android.support.annotation.NonNull;


public final class Person implements Comparable<Person>{
    private int id;
    private String name;
    private long arriveTime;
    private long leaveTime;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public long getLeaveTime() {
        return leaveTime;
    }

    @Override
    public int compareTo(@NonNull Person person) {
        if (this.getArriveTime() < person.getArriveTime()) return -1;
        if (this.getArriveTime() > person.getArriveTime()) return 1;
        else return 0;
    }

}

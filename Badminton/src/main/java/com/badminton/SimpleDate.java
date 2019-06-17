package com.badminton;

public class SimpleDate {
    private int year;
    private int month;
    private int day;
    private int startClock;
    private int endClock;

    public SimpleDate(int year, int month, int day, int startClock, int endClock){
        this.year = year;
        this.month = month;
        this.day = day;
        this.startClock = startClock;
        this.endClock = endClock;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

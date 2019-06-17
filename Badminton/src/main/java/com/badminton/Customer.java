package com.badminton;

public class Customer {
    String userID;
    int year;
    int month;
    int day;
    int startClock;
    int endClock;
    String place;

//	public Customer() {
//		// TODO Auto-generated constructor stub
//
//	}

    public Customer(String userID, int year,int month, int day, int startClock, int endClock, String place) {
        super();
        this.year = year;
        this.userID = userID;
        this.month = month;
        this.day = day;
        this.startClock = startClock;
        this.endClock = endClock;
        this.place = place;
    }
    public boolean isIdEqual(Customer c){
        if(this.userID.equals(c.userID))
            return true;
        return false;
    }
    public boolean isDateEqual(Customer c) {
        if(this.year==c.year&&this.day==c.day&&this.month==c.month)
            return true;
        return false;
    }
    public boolean isplaceEqual(Customer c) {
        if(this.place.equals(c.place))
            return true;
        return false;
    }
    public boolean isEqual(Customer c) {
        if(this.userID.equals(c.userID) &&this.year==c.year&&this.month==c.month
                &&this.day ==c.day&&this.startClock==c.startClock&&this.endClock==c.endClock
        )
            return true;
        return false;
    }
    public boolean isTimeConflict(Customer c) {
        if(isDateEqual(c) &&(


                (this.startClock < c.startClock && this.endClock < c.endClock && this.endClock > c.startClock)
                        ||(this.startClock > c.startClock && this.startClock < c.endClock && this.endClock > c.startClock && this.endClock < c.endClock)
                        ||(this.startClock > c.startClock && this.startClock < c.endClock && this.endClock > c.endClock)
                        ||(c.startClock < this.startClock && c.endClock < this.endClock && c.endClock > this.startClock)
                        ||(c.startClock > this.startClock && c.startClock < this.endClock && c.endClock > this.startClock && c.endClock < this.endClock)
                        ||(c.startClock > this.startClock && c.startClock < this.endClock && c.endClock > this.endClock)

        )
                && isplaceEqual(c)
        )
            return true;
        return false;


    }

}
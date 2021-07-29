package entities;

import java.util.Objects;

public class Event {
    public int year;
    public int month;
    public int day;
    public String name;


    public Event(int year, int month, int day, String name) {
        this.day = day;
        this.year = year;
        this.month = month;
        this.name = name;
    }

    public String toString() {
        return "Event{year=" + year + ", month=" + month + ", day=" + day + ", name=" + "'" + name + "'" + "}";
    }
    public boolean equals(Event that){
        boolean result;
        if (that==null){
            return false;
        }
        if (this.name==null&&that.name==null){
            result=true;
        }

        result= this.day == that.day &&
                this.year == that.year &&
                this.month == that.month &&
                Objects.equals(this.name, that.name);
        return result;
    }



}


package entities;

import java.util.Objects;

public class Event {
    private int year;
    private int month;
    private int day;
    private String name;


    public Event(int year, int month, int day, String name) {
        this.day = day;
        this.year = year;
        this.month = month;
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return "Event{year=" + getYear() + ", month=" + getMonth() + ", day=" + getDay() + ", name=" + "'" + getName() + "'" + "}";
    }

    public boolean equals(Event that) {
        boolean result;
        if (that == null) {
            return false;
        }
        if (this.name == null && that.name == null) {
            result = true;
        }
        result = this.day == that.day &&
                this.year == that.year &&
                this.month == that.month &&
                Objects.equals(this.name, that.name);
        return result;
    }

    public int compareTo(Event that) {
        int number;
        if (this.day == that.day && this.month == that.month && this.year == that.year) {
            number = 0;
        } else if (this.day > that.day && this.month == that.month && this.year == that.year) {
            number = 1;
        }
        else if ( this.month > that.month && this.year == that.year) {
            number = 1;
        }
        else if ( this.year > that.year) {
            number = 1;
        } else {
            number = -1;
        }

        return number;
    }



}


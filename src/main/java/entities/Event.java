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

    /**
     * Create the string
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string
     */
    public String toString() {
        return "Event{year=" + getYear() + ", month=" + getMonth() + ", day=" + getDay() + ", name=" + "'" + getName() + "'" + "}";
    }

    /**
     * Make a compare between two events
     *
     * n=name.length
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param that the first term
     * @return result of  compare
     */
    public boolean equals(Event that) {
        if (that == null) {
            return false;
        }
        if (that.name == null && this.name != null) {
            return false;

        }

        return (( this.name == null && that.name == null || (that.name.equals(this.name))) &&
                (this.year == that.year && this.month == that.month && that.day == this.day));
    }

    /**
     * Compare two events
     *
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param that the first term
     *
     * @return number
     */
    public int compareTo(Event that) {
        int number;
        if (this.day == that.day && this.month == that.month && this.year == that.year) {
            number = 0;
        } else if (this.day > that.day && this.month == that.month && this.year == that.year) {
            number = 1;
        } else if (this.month > that.month && this.year == that.year) {
            number = 1;
        } else if (this.year > that.year) {
            number = 1;
        } else {
            number = -1;
        }
        return number;
    }
}


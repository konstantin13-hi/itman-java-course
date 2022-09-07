package entities;

import java.util.Objects;

public class Event {
    private int year;
    private int month;
    private int day;
    private int id;
    private String name;

    public Event(int year, int month, int day, String name) {
        this.day = day;
        this.year = year;
        this.month = month;
        this.name = name;
    }

    public Event(int id, int year, int month, int day, String name) {
        this.id = id;
        this.day = day;
        this.year = year;
        this.month = month;
        this.name = name;
    }

    public Event() {
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

    public int getId() {
        return id;
    }

    /**
     * Create the string.
     * n=amount of letters in string getName
     *
     * @return string
     * @cpu 0(n)
     * @ram 0(n)
     */
    public String toString() {
        return "Event{id=" + getId() + ", year=" + getYear() +
                ", month=" + getMonth() + ", day=" + getDay() + ", name=" + "'" + getName() + "'" + "}";
    }

    /**
     * Make a compare between two events.
     *
     * @param obj the first term
     * @return result of  compare
     * @cpu 0(1)
     * @ram 0(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Event that = (Event) obj;
        return this.id == that.id
                && Objects.equals(this.name, that.name)
                && this.year == that.year
                && this.month == that.month && this.day == that.day;
    }

    /**
     * Compare two events.
     *
     * @param that the first term
     * @return number
     * @cpu 0(1)
     * @ram 0(1)
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


package entities;

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
        return "Event{year="+year+", month="+month+", day="+day+", name="+"'"+name+"'"+"}";
    }
}


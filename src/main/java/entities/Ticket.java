package entities;

import java.util.Objects;

public class Ticket {
    public int number;
    public static String place;

    public Ticket(int number, String place) {
        Ticket.place = place;
        this.number = number;
    }
    public String toString(){
        return "Ticket{number=" + number + ", place=" + "'" + place + "'" + "}";
    }
    public boolean equals(Ticket that) {
        boolean result;
        if (that == null) {
            return false;
        }
        if (place == null ) {
            result = true;
        }
        result = this.number == that.number &&
                Objects.equals(place, place);
        return result;
    }


}




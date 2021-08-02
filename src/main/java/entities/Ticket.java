package entities;

import java.util.Objects;

public class Ticket {
    public int number;
    public  String place;

    public Ticket(int number, String place) {
        this.place = place;
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
        if (place == null&& that.place==null ) {
            result = true;
        }
        result = this.number == that.number &&
                Objects.equals(place, that.place);
        return result;
    }


}




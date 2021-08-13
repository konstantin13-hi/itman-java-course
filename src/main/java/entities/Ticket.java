package entities;

import java.util.Objects;

public class Ticket {
    private  int number;
    private  String place;
    public int getNumber() {
        return number;
    }
    public String getPlace() {
        return place;
    }

    public Ticket(int number, String place) {
        this.place = place;
        this.number = number;
    }
    public String toString(){
        return "Ticket{number=" + getNumber() + ", place=" + "'" + getPlace() + "'" + "}";
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




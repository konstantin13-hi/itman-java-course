package entities;

import java.util.Objects;

public class Ticket {
    private int number;
    private String place;

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

    /**
     * Create string which consists information.
     *
     * @return new string
     * @cpu 0(1)
     * @ram 0(1)
     */

    public String toString() {
        return "Ticket{number=" + getNumber() + ", place=" + "'" + getPlace() + "'" + "}";
    }

    /**
     * Equal between two tickets.
     *
     * @param obj the first term
     * @return result comparison
     * @cpu 0(1)
     * @ram 0(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.number == ((Ticket) obj).number && Objects.equals(this.place, ((Ticket) obj).place);
    }

}




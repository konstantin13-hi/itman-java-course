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
     * Create string which consists information
     *
     * @return new string
     * @cpu 0(1)
     * @ram 0(1)
     */

    public String toString() {
        return "Ticket{number=" + getNumber() + ", place=" + "'" + getPlace() + "'" + "}";
    }

    /**
     * Equal between two tickets
     *
     * @param obj the first term
     * @return result comparison
     * @cpu 0(1)
     * @ram 0(1)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return Objects.equals(this.toString(), obj.toString()) && this.getClass() == obj.getClass();
    }
   /* public boolean equals(Ticket that) {
        boolean result;
        if (that == null) {
            return false;
        }
        if (place == null && that.place == null) {
            result = true;
        }
        result = this.number == that.number &&
                Objects.equals(place, that.place);
        return result;
    }

    */
}




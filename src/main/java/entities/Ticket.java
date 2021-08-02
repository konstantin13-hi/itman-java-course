package entities;

import java.util.Objects;

public class Ticket {
    public int number;
    public String name;

    public Ticket(int number, String name) {
        this.name = name;
        this.number = number;
    }
    public String toString(){
        return "Ticket{number=" + number + ", place=" + "'" + name + "'" + "}";
    }
    public boolean equals(Ticket that) {
        boolean result;
        if (that == null) {
            return false;
        }
        if (this.name == null && that.name == null) {
            result = true;
        }
        result = this.number == that.number &&
                Objects.equals(this.name, that.name);
        return result;
    }


}




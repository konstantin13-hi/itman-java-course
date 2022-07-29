package entities.items;

import java.util.Objects;

public class BoardGame extends Game {
    private int timeMin;
    private int timeMax;

    public BoardGame(int id, String title, int price, int playersMin, int playersMax, int timeMin, int timeMax) {
        super(id, title, price, playersMin, playersMax);
        this.timeMin = timeMin;
        this.timeMax = timeMax;
    }


    public int getTimeMin() {
        return timeMin;
    }

    public int getTimeMax() {
        return timeMax;
    }

    /**
     * @return string
     */

    public String toString() {
        return "BoardGame{" + super.toString() + ", timeMin=" + timeMin + ", timeMax=" + timeMax + "}";
    }
    /**
     * Equals two objects
     * @cpu O(1)
     * @ram O(1)
     * @param obj the first term
     * @return result of equals two objects
     */


    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return Objects.equals(this.toString(), obj.toString());
    }
}

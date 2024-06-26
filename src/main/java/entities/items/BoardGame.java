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
     * Returns string with data about BoardGame.
     * n=title length
     *
     * @return string
     * @cpu O(n)
     * @ram O(n)
     */
    public String toString() {
        return "BoardGame{" + super.toString() + ", timeMin=" + timeMin + ", timeMax=" + timeMax + "}";
    }

    /**
     * Equals two objects.
     * n=Tittle's length
     *
     * @param obj the first term
     * @return result of equals two objects
     * @cpu O(n)
     * @ram O(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        BoardGame that = (BoardGame) obj;
        return timeMin == that.timeMin
                && timeMax == that.getTimeMax() && super.equals(that);
    }
}

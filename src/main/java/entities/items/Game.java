package entities.items;

import java.util.Objects;

public class Game extends Item {
    private int playersMin;
    private int playersMax;

    public int getPlayersMin() {
        return playersMin;
    }

    public int getPlayersMax() {
        return playersMax;
    }

    public Game(int id, String title, int price, int playersMin, int playersMax) {
        super(id, title, price);
        this.playersMin = playersMin;
        this.playersMax = playersMax;
    }

    /**
     * Returns string with data about item.
     * n=title length
     *
     * @return string
     * @cpu O(n)
     * @ram O(n)
     */

    public String toString() {
        return "Game{" + super.toString() + ", playersMin=" + playersMin + ", playersMax=" + playersMax + "}";
    }

    /**
     * Equals two objects.
     * n=Tittle's length
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param obj the first term
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Game that = (Game) obj;
        return playersMax == that.playersMax
                && playersMin == that.playersMin && super.equals(that);
    }
}

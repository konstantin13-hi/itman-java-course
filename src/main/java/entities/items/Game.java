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
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param obj the first term
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return super.getId() == ((Game) obj).getId()
                && super.getPrice() == ((Game) obj).getPrice()
                && Objects.equals(super.getTitle(), ((Game) obj).getTitle())
                && playersMax == ((Game) obj).playersMax
                && playersMin == ((Game) obj).playersMin;
    }
}

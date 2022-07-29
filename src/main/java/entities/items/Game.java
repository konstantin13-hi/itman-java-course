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
     * Returns string with data about item
     *
     * n=title length
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @return string
     */

    public String toString() {
        return "Game{" + super.toString() + ", playersMin=" + playersMin + ", playersMax=" + playersMax + "}";
    }
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        return Objects.equals(this, obj);
    }
}

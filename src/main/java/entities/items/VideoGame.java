package entities.items;

import java.util.Objects;

public class VideoGame extends Game {
    private String platform;

    public VideoGame(int id, String title, int price, int playersMin, int playersMax, String platform) {
        super(id, title, price, playersMin, playersMax);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    /**
     * Returns string with data about item.
     * n=platform length
     * m=super toString
     *
     * @return string
     * @cpu O(n+m)
     * @ram O(n+m)
     */
    public String toString() {
        return "VideoGame{" + super.toString() + ", platform='" + platform + "'}";
    }

    /**
     * Makes equals between two objects.
     *
     * @cpu O(1)
     * @ram O(1)
     * @param obj the first term
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return super.getId() == ((VideoGame) obj).getId()
                && super.getPrice() == ((VideoGame) obj).getPrice()
                && super.getPlayersMax() == ((VideoGame) obj).getPlayersMax()
                && super.getPlayersMin() == ((VideoGame) obj).getPlayersMin()
                && Objects.equals(this.platform, ((VideoGame) obj).platform);
    }
}

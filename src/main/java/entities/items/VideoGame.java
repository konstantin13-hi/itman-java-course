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
     * n=Tittle's length
     *
     * @cpu O(n)
     * @ram O(1)
     * @param obj the first term
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        VideoGame that = (VideoGame) obj;
        return Objects.equals(this.platform, that.platform) && super.equals(that);
    }
}

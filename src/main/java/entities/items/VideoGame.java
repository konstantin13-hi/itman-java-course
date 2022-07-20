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

    public String toString() {
        return "VideoGame{" + super.toString() + ", platform='" + platform + "'}";
    }
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        return Objects.equals(this.toString(), obj.toString());
    }
}

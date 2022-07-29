package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VideoGameTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            VideoGame v = new VideoGame(1,"Title",111,2,10,"GGG");
            Assertions.assertEquals("VideoGame{Game{Item{id=1, title='Title', price=111}, playersMin=2, playersMax=10}, platform='GGG'}", v.toString());
        }
    }
}


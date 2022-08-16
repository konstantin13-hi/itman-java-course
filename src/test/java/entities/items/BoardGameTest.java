package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            BoardGame b = new BoardGame(1, "Title", 111,
                    1, 4, 10, 100);
            Assertions.assertEquals("BoardGame{Game{Item{id=1,"
                    + " title='Title', price=111}, playersMin=1,"
                    + " playersMax=4}, timeMin=10, timeMax=100}", b.toString());
        }
    }
}
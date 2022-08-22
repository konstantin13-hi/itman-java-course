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

    @Nested
    public class Equals {
        @Test
        public void shouldEqualsWhenObjectDifferent() {
            BoardGame b = new BoardGame(1, "Title", 111,
                    1, 4, 10, 100);
            BoardGame a = new BoardGame(2, "Tit", 111,
                    1, 4, 10, 100);
            Assertions.assertNotEquals(b, a);
        }

        @Test
        public void shouldEqualsWhenObjectAreSame() {
            BoardGame b = new BoardGame(1, "Tit", 111,
                    1, 4, 10, 100);
            BoardGame a = new BoardGame(1, "Tit", 111,
                    1, 4, 10, 100);
            Assertions.assertEquals(b, a);
        }
    }
}
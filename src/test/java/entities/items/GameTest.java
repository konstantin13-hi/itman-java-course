package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameTest {
    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            Game game = new Game(1, "Title", 100, 1, 10);
            Assertions.assertEquals("Game{Item{id=1, title='Title', price=100},"
                    + " playersMin=1, playersMax=10}", game.toString());

        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldEqualsWhenObjectsDifferent() {
            Assertions.assertNotEquals(new Game(1, "R", 100, 1, 10),
                    new Game(1, "Title", 100, 1, 10));
        }

        @Test
        public void shouldEqualsWhenObjectsAreSame() {
            Assertions.assertEquals(new Game(1, "Title", 100, 1, 10),
                    new Game(1, "Title", 100, 1, 10));
        }
    }
}
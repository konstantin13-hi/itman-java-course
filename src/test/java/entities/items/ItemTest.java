package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class ItemTest {
    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            Item i = new Item(1, "Title", 111);
            Assertions.assertEquals("Item{id=1, title='Title', price=111}", i.toString());
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            Assertions.assertEquals(new Item(1, "Title", 111),
                    new Item(1, "Title", 111));
        }

        @Test
        public void shouldReturnStringWhenObjectIsNotEmpy() {
            Assertions.assertNotEquals(new Item(1, "Title", 111),
                    new Item(1, "Title", 1));
        }
    }
}


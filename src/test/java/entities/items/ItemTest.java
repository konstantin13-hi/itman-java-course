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
}


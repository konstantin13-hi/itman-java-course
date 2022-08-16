package entities.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            Book book = new Book(1, "Title", 100, "Author", 10);
            Assertions.assertEquals("Book{Item{id=1, title='Title', price=100},"
                    + " author='Author', pages=10}", book.toString());
        }
    }

}
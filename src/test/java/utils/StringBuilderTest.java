package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringBuilderTest {
    @Nested

    public class Append {

        @Test
        public void shouldReturnStringWhenUsesDoubleStringInt() {
            StringBuilder s = new StringBuilder();
            s.append(2.0);
            s.append("+");
            s.append(2);
            s.append("=");
            s.append(4);
            Assertions.assertEquals("2.0+2=4", s.toString());
        }

        @Test
        public void shouldReturnStringWhenAddWordWithCapacityOne() {
            StringBuilder s = new StringBuilder(1);
            String actual = s.append("itman").toString();
            Assertions.assertEquals("itman", actual);
            Assertions.assertEquals(5, s.length());
        }

        @Test
        public void shouldReturnsStringWhenAddWordNull() {
            StringBuilder s = new StringBuilder(1);
            String actual = s.append("null").toString();
            Assertions.assertEquals("null", actual);
            Assertions.assertEquals(4, s.length());
        }

        @Test
        public void shouldReturnStringWhenAddNull() {
            StringBuilder s = new StringBuilder(1);
            String actual = s.append(null).toString();
            Assertions.assertEquals("" + null, actual);
            Assertions.assertEquals(4, s.length());
        }

        @Test
        public void shouldReturnStringWhenAddThreeWordsWithCapacityTwo() {
            StringBuilder s = new StringBuilder(2);
            s.append("itman");
            s.append("ff");
            s.append("lol");
            Assertions.assertEquals("itmanfflol", s.toString());
        }

    }
}
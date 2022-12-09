package collections;

import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
    @Nested
    public class FindMin {
        @Test
        void shouldFindMinWhenArrayIsNotEmpty() {
            List<Integer> list = new LinkedList<>();
            list.add(3);
            list.add(5);
            list.add(0);
            list.add(10);
            list.add(8);
            Assertions.assertEquals(0, CollectionUtils.findMin(list,
                    Comparator.comparingInt(o -> o)));
        }
    }

    @Nested
    public class FindMax {
        @Test
        void shouldFindMinWhenArrayIsNotEmpty() {
            List<Integer> list = new LinkedList<>();
            list.add(3);
            list.add(5);
            list.add(0);
            list.add(10);
            list.add(8);
            Assertions.assertEquals(10, CollectionUtils.findMax(list,
                    Comparator.comparingInt(o -> o)));
        }
    }

    @Nested
    public class Sort {
        @Test
        void shouldSortWhenArrayIsNotEmpty() {
            List<Integer> list = new LinkedList<>();
            list.add(3);
            list.add(5);
            list.add(2);
            list.add(4);
            list.add(1);
            CollectionUtils.sort(list);
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, list.toArray());
        }
    }

    @Nested
    public class Reverse {
        @Test
        void shouldReverseWhenArrayIsNotEmpty() {
            List<Integer> list = new LinkedList<>();
            list.add(3);
            list.add(5);
            list.add(2);
            list.add(4);
            list.add(1);
            CollectionUtils.reverse(list);
            Assertions.assertArrayEquals(new Integer[]{1, 4, 2, 5, 3}, list.toArray());
        }
    }
}
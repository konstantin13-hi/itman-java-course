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
            List<Integer> list = new LinkedList<Integer>();
            list.add(3);
            list.add(5);
            list.add(0);
            list.add(10);
            list.add(8);

            Comparator<Integer> comparator = (o1, o2) -> {
                int result = 0;
                if (o1 > o2) {
                    result = 1;
                } else if (o1 < o2) {
                    result = -1;
                }
                return result;
            };
            Assertions.assertEquals(0, CollectionUtils.findMin(list,
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
        }
    }
}
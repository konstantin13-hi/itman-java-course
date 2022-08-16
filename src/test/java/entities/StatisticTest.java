package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    @Nested
    public class ToString {
        @Test
        public void shouldReturnsStringWhenObjectIsNotEmpty() {
            Statistic statistic = new Statistic(1, 2, 3, 4, 5);
            Assertions.assertEquals("Statistic{min=" + 1 + ", max="
                    + 2 + ", count=" + 3 + ", average=" + 4.0 + ", median="
                    + 5.0 + "}", statistic.toString());
        }

    }

    @Nested
    public class Equals {
        @Test
        void shouldEqualsWhenTwoObjectsAreSame() {
            Statistic statistic = new Statistic(1, 2, 3, 4, 5);
            Statistic statisticSecond = new Statistic(1, 2, 3, 4, 5);
            Assertions.assertTrue(statistic.equals(statisticSecond));
        }

        @Test
        void shouldEqualsWhenTwoObjectsAreDifferent() {
            Statistic statistic = new Statistic(1, 4, 3, 4, 5);
            Statistic statisticSecond = new Statistic(1, 21, 3, 4, 5);
            Assertions.assertFalse(statistic.equals(statisticSecond));
        }
    }
}
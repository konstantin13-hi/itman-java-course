package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    @Test
    public void testToString() {
        Statistic statistic = new Statistic(1, 2, 3, 4, 5);
        Assertions.assertEquals("Statistic{min=" + 1 + ", max=" + 2 + ", count=" + 3 + ", average=" + 4.0 + ", median=" + 5.0 + "}", statistic.toString());
    }

    @Test
    void testEquals() {
        Statistic statistic = new Statistic(1, 2, 3, 4, 5);
        Statistic statisticSecond = new Statistic(1, 2, 3, 4, 5);
        Assertions.assertTrue(statistic.equals(statisticSecond));
    }
}
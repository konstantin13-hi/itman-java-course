package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task510Test {

    @Test
    void mostFrequent() {
        int []array =new int [] {1, 2, 5, 1, 2 ,2 ,3, 1};
       int  expected = 1;
       Assertions.assertEquals(expected,Task510.mostFrequent(array));
    }

    @Test
    void mostFrequent1() {
        int []array =new int [] {1, 1, 1, 1, 2 ,2 ,2, 2};
        int  expected = 1;
        Assertions.assertEquals(expected,Task510.mostFrequent(array));
    }
    @Test
    void mostFrequent2() {
        int []array =new int [] {1, 1, 1, 1, 1 ,1 ,1, 1};
        int  expected = 1;
        Assertions.assertEquals(expected,Task510.mostFrequent(array));
    }


}
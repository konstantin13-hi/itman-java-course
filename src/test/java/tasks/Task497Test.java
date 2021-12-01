package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task497Test {
    @Test
    public void merge(){
        int [] first =new int[]{1,2,3};
        int [] second =new int[]{3,4,5,6,7,8};
        int [] expected = new int[]{1,2,3,3,4,5,6,7,8};
        Assertions.assertArrayEquals(expected,Task497.merge(first,second));

    }
    @Test
    public void merge2(){
        int [] first =new int[]{1,2,3,4,5,6,7,8,9,10};
        int [] second =new int[]{3,4,5,6,7,8};
        int [] expected = new int[]{1,2,3,3,4,4,5,5,6,6,7,7,8,8,9,10};
        Assertions.assertArrayEquals(expected,Task497.merge(first,second));

    }

}
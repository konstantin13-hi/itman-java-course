package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ArrayListTest {

    @Test
    void size() {
        ArrayList arrayList = new ArrayList(4);
        Assertions.assertEquals(0, arrayList.size());
    }

    @Test
    void get() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.set(0, 1);
        Assertions.assertEquals(1, arrayList.get(0));
    }

    @Test
    void get2() {
        ArrayList arrayList = new ArrayList(100);
        arrayList.set(20, 33);
        Assertions.assertEquals(33, arrayList.get(20));
    }




}
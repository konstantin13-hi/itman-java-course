package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class ArrayListTest {

    @Test
    void size() {
        ArrayList arrayList = new ArrayList(4);
        Assertions.assertEquals(0, arrayList.size());
    }

    @Test
    void setIndexZeroNumberOne() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.set(0, 1);
        Assertions.assertEquals(1, arrayList.get(0));
    }

    @Test
    void setIndexTwentyNumberThirtyThree() {
        ArrayList arrayList = new ArrayList(100);
        arrayList.set(20, 33);
        Assertions.assertEquals(33, arrayList.get(20));
    }

    @Test
    void toArray() {
        ArrayList arrayList = new ArrayList(10);
        int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        addElement(array, arrayList);
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, arrayList.toArray());
    }
    @Nested
    public class Remove {

        @Test
        public void remove() {
            ArrayList arrayList = new ArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, arrayList);
            arrayList.remove(2);
            Assertions.assertArrayEquals(new int[]{1, 2, 4, 5}, arrayList.toArray());
        }
    }
    @Test
    public void get() {
        ArrayList arrayList = new ArrayList(5);
        int[] array = new int[]{100, 2111, 377, 488888, 51231};
        addElement(array, arrayList);
        Assertions.assertEquals(377, arrayList.get(2));
    }
    @Nested
    public class equal {

        @Test
        public void equals() {
            ArrayList arrayList = new ArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, arrayList);
            ArrayList arrayListSecond = new ArrayList(5);
            int[] arraySecond = new int[]{1, 2, 3, 4, 5};
            addElement(arraySecond, arrayListSecond);
            Assertions.assertTrue(arrayList.equals(arrayListSecond));
        }

        @Test
        public void equalsIfDifferentLengths() {
            ArrayList arrayList = new ArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, arrayList);
            ArrayList arrayListSecond = new ArrayList(5);
            int[] arraySecond = new int[]{1, 2, 3};
            addElement(arraySecond, arrayListSecond);
            Assertions.assertFalse(arrayList.equals(arrayListSecond));

        }
    }
    @Nested
    public class sort {
        @Test
        public void sort() {
            ArrayList arrayList = new ArrayList(20);
            int[] array = new int[]{11, 2, 33, 1, 5};
            addElement(array, arrayList);
            arrayList.sort();
            ArrayList arrayListSecond = new ArrayList(20);
            int[] arraySecond = new int[]{1, 2, 5, 11, 33};
            addElement(arraySecond, arrayListSecond);
            checkElement(arrayList, arrayListSecond);
        }

        @Test
        public void sortIfHaveNegativeNumber() {
            ArrayList arrayList = new ArrayList(6);
            int[] array = new int[]{5, 1, 1, 2, -3, 1};
            addElement(array, arrayList);
            arrayList.sort();
            ArrayList arrayListSecond = new ArrayList(6);
            int[] arraySecond = new int[]{-3, 1, 1, 1, 2, 5};
            addElement(arraySecond, arrayListSecond);
            checkElement(arrayList, arrayListSecond);
        }
    }
    public static void checkElement(ArrayList arrayList, ArrayList arrayListSecond) {
        for (int i = 0; i < arrayList.size(); i++) {
            Assertions.assertEquals(arrayListSecond.get(i), arrayList.get(i));
        }
    }

    @Test
    public void arrayList() {
        ArrayList arrayList = new ArrayList(100);
        int[] array = new int[]{10, 20, 30};
        addElement(array, arrayList);
        ArrayList that = new ArrayList(arrayList);
        Assertions.assertTrue(arrayList.equals(that));

    }

    @Test
    public void of() {
        int[] elements = new int[]{1, 2, 3};
        ArrayList.of(elements);
        for (int i = 0; i < elements.length; i++) {
            Assertions.assertEquals(elements[i], ArrayList.of(elements).get(i));
        }

    }

    @Test
    public void string() {
        ArrayList arrayList = new ArrayList();
        int[] array = new int[]{1, 3, 99};
        addElement(array, arrayList);
        Assertions.assertEquals("[1, 3, 99]", arrayList.toString());
    }

    @Test
    public void stringIfArrayListEmpty() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertEquals("[]", arrayList.toString());
    }

    public static void addElement(int[] x, ArrayList arrayList) {
        for (int j : x) {
            arrayList.add(j);
        }
    }
}
package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class IntArrayListTest {

    @Nested
    public class Size {

        @Test
        void shouldReturnSizeWhenArrayListIsEmpty() {
            IntArrayList intArrayList = new IntArrayList(4);
            Assertions.assertEquals(0, intArrayList.size());
        }

        @Test
        void shouldReturnSizeWhenArrayListIsNotEmpty() {
            IntArrayList intArrayList = new IntArrayList(4);
            intArrayList.add(55);
            Assertions.assertEquals(1, intArrayList.size());
        }
    }

    @Nested
    public class Set {

        @Test
        void shouldSetElementWhenIndexZeroNumberOne() {
            IntArrayList intArrayList = new IntArrayList(4);
            intArrayList.set(0, 1);
            Assertions.assertEquals(1, intArrayList.get(0));
        }

        @Test
        void shouldSetElementWhenIndexTwentyNumberThirtyThree() {
            IntArrayList intArrayList = new IntArrayList(100);
            intArrayList.set(20, 33);
            Assertions.assertEquals(33, intArrayList.get(20));
        }
    }

    @Nested
    public class ToArray {

        @Test
        void shouldReturnArrayWhenArrayListIsNotEmpty() {
            IntArrayList intArrayList = new IntArrayList(10);
            int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1};
            addElement(array, intArrayList);
            Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, intArrayList.toArray());
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveElementWhenArrayListIsNotEmpty() {
            IntArrayList intArrayList = new IntArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, intArrayList);
            intArrayList.remove(2);
            Assertions.assertArrayEquals(new int[]{1, 2, 4, 5}, intArrayList.toArray());
        }
    }

    @Nested
    public class Get {
        @Test
        public void shouldGetElementWhenArrayListIsNotEmpty() {
            IntArrayList intArrayList = new IntArrayList(5);
            int[] array = new int[]{100, 2111, 377, 488888, 51231};
            addElement(array, intArrayList);
            Assertions.assertEquals(377, intArrayList.get(2));
        }
    }

    @Nested
    public class Equals {

        @Test
        public void shouldReturnTrueWhenArrayListsAreSame() {
            IntArrayList intArrayList = new IntArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, intArrayList);
            IntArrayList intArrayListSecond = new IntArrayList(5);
            int[] arraySecond = new int[]{1, 2, 3, 4, 5};
            addElement(arraySecond, intArrayListSecond);
            Assertions.assertEquals(intArrayList, intArrayListSecond);
        }

        @Test
        public void shouldReturnTrueWhenDifferentLengths() {
            IntArrayList intArrayList = new IntArrayList(5);
            int[] array = new int[]{1, 2, 3, 4, 5};
            addElement(array, intArrayList);
            IntArrayList intArrayListSecond = new IntArrayList(5);
            int[] arraySecond = new int[]{1, 2, 3};
            addElement(arraySecond, intArrayListSecond);
            Assertions.assertNotEquals(intArrayList, intArrayListSecond);

        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortElementWhenHaveNotNegativeNumber() {
            IntArrayList intArrayList = new IntArrayList(20);
            int[] array = new int[]{11, 2, 33, 1, 5};
            addElement(array, intArrayList);
            intArrayList.sort();
            IntArrayList intArrayListSecond = new IntArrayList(20);
            int[] arraySecond = new int[]{1, 2, 5, 11, 33};
            addElement(arraySecond, intArrayListSecond);
            checkElement(intArrayList, intArrayListSecond);
        }

        @Test
        public void shouldSortElementWhenHaveNegativeNumber() {
            IntArrayList intArrayList = new IntArrayList(6);
            int[] array = new int[]{5, 1, 1, 2, -3, 1};
            addElement(array, intArrayList);
            intArrayList.sort();
            IntArrayList intArrayListSecond = new IntArrayList(6);
            int[] arraySecond = new int[]{-3, 1, 1, 1, 2, 5};
            addElement(arraySecond, intArrayListSecond);
            checkElement(intArrayList, intArrayListSecond);
        }
    }

    @Nested
    public class CreateArrayList {
        @Test
        public void shouldCopyElementsFromFirsArrayListWhenSecondIsEmpty() {
            IntArrayList intArrayList = new IntArrayList(100);
            int[] array = new int[]{10, 20, 30};
            addElement(array, intArrayList);
            IntArrayList that = new IntArrayList(intArrayList);
            Assertions.assertEquals(intArrayList, that);
        }
    }

    @Nested
    public class Of {

        @Test
        public void shouldAddElementsWhenArrayListIsEmpty() {
            int[] elements = new int[]{1, 2, 3};
            IntArrayList.of(elements);
            for (int i = 0; i < elements.length; i++) {
                Assertions.assertEquals(elements[i], IntArrayList.of(elements).get(i));
            }

        }
    }

    @Nested
    public class ToString {

        @Test
        public void shouldReturnStringWhenArrayListIsNotEmpty() {
            IntArrayList intArrayList = new IntArrayList();
            int[] array = new int[]{1, 3, 99};
            addElement(array, intArrayList);
            Assertions.assertEquals("[1, 3, 99]", intArrayList.toString());
        }

        @Test
        public void shouldReturnStringWhenArrayListIEmpty() {
            IntArrayList intArrayList = new IntArrayList();
            Assertions.assertEquals("[]", intArrayList.toString());
        }
    }

    private static void addElement(int[] x, IntArrayList intArrayList) {
        for (int j : x) {
            intArrayList.add(j);
        }
    }

    private static void checkElement(IntArrayList intArrayList, IntArrayList intArrayListSecond) {
        for (int i = 0; i < intArrayList.size(); i++) {
            Assertions.assertEquals(intArrayListSecond.get(i), intArrayList.get(i));
        }
    }
}
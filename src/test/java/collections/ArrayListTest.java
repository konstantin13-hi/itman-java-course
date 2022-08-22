package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;

class ArrayListTest {
    @Nested
    public class Set {
        @Test
        public void shouldSetWhenArrayIsNotEmpty() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            arrayList.add("D");
            arrayList.add("E");
            arrayList.set(2, "CC");
            Assertions.assertArrayEquals(new Object[]{"A", "B", "CC", "D", "E"}, arrayList.toArray());

        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldEqualsWhenSecondArrayHasNull() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            arrayList.add("D");
            arrayList.add(null);
            ArrayList arrayListSecond = ArrayList.of("A", "B", "C", "D", "E");
            Assertions.assertNotEquals(arrayList, arrayListSecond);
        }

        @Test
        public void shouldEqualsWhenAddEmptyString() {
            Assertions.assertEquals(ArrayList.of(new MyString(new char[]{})),
                    ArrayList.of(new MyString(new char[]{})));
        }

        @Test
        public void shouldEqualsWhenDifferentTypes() {
            Assertions.assertNotEquals(ArrayList.of(new MyString(new char[]{})),
                    ArrayList.of((Object) new Integer[]{1, 3, 3}));
        }
    }

}
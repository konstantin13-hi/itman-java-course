package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;

class ArrayListTest extends AbstractListTest {
    @Override
    protected List createList() {
        return new ArrayList();
    }

    @Override
    protected List of(final Object... elements) {
        return ArrayList.of(elements);
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
package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;

import java.util.Comparator;
import java.util.ConcurrentModificationException;


public abstract class AbstractListTest {
    protected abstract <T> List<T> createList();

    protected abstract <T> List<T> of(Object... elements);


    @Nested
    public class Add {

        @Test
        public void shouldAddElementWhenListIsNotEmpty() {
            List<Object> list = createList();
            list.add(1);
            Assertions.assertArrayEquals(new Object[]{1}, list.toArray());
            list.add("5");
            list.add(6);
            Assertions.assertArrayEquals(new Object[]{1, "5", 6}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenIndexFirst() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            list.add(0, 0);
            list.toArray();
            Assertions.assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenIndexMiddle() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            list.add(2, 0);
            list.toArray();
            Assertions.assertArrayEquals(new Integer[]{1, 2, 0, 3, 4, 5}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenIndexLast() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            list.add(5, 0);
            list.toArray();
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 0}, list.toArray());
        }

        @Test
        public void shouldAddElementWhenIndexNegative() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 0));
        }

        @Test
        public void shouldAddElementWhenIndexMoreThanLength() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(6, 0));
        }


    }


    @Nested
    public class Get {
        @Test
        public void shouldGetElementWhenListIsNotEmpty() {
            List<Object> list = of("12", 2, 1, new Ticket(1, "sde"));
            Assertions.assertEquals(1, list.get(2));
            Assertions.assertEquals("12", list.get(0));
            Assertions.assertEquals(2, list.get(1));
        }

        @Test
        public void shouldAddElementWhenIndexNegative() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));

        }

        @Test
        public void shouldAddElementWhenIndexMoreThanLength() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
        }


    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveElementByIndexWhenListIsNotEmpty() {
            List<Object> list = of("12", 2, 1, new Ticket(1, "sde"), 33);
            Assertions.assertEquals(1, list.remove(2));
            Assertions.assertEquals("12", list.remove(0));
            Assertions.assertEquals(33, list.remove(2));
            Assertions.assertArrayEquals(new Object[]{2, new Ticket(1, "sde")}, list.toArray());
        }

        @Test
        public void shouldRemoveElementWhenListIsNotEmpty() {
            List<Object> list = of("12", 2, 1, new Ticket(1, "sde"), 33);
            Assertions.assertEquals(1, list.remove(Integer.valueOf(1)));
            Assertions.assertEquals("12", list.remove("12"));
            Assertions.assertEquals(33, list.remove(Integer.valueOf(33)));
            Assertions.assertArrayEquals(new Object[]{2, new Ticket(1, "sde")}, list.toArray());
        }

    }

    @Nested
    public class Set {
        @Test
        public void shouldSetElementWhenListIsNotEmpty() {
            List<Object> list = of(1, 2, 3, 4, 5);
            list.set(4, "1");
            list.set(3, "2");
            list.set(2, "3");
            list.set(1, "4");
            list.set(0, "5");
            Assertions.assertArrayEquals(new Object[]{"5", "4", "3", "2", "1"}, list.toArray());

        }

    }

    @Nested
    public class ToString {
        @Test
        public void shouldToStringWhenListIsNotEmpty() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertEquals("[1, 2, 3, 4, 5]", list.toString());

        }

        @Test
        public void shouldToStringWhenListIsEmpty() {
            List<Integer> list = of();
            Assertions.assertEquals("[]", list.toString());

        }
    }


    @Nested
    public class ToArray {
        @Test
        public void shouldToArrayWhenListIsNotEmpty() {
            List<Object> list = of(1, 2, 3, 4, 5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldToArrayWhenListIsEmpty() {
            List<Integer> list = of();
            Assertions.assertArrayEquals(new Object[]{}, list.toArray());

        }

        @Test
        public void shouldIntFunctionWhenListIsNotEmpty() {
            List<Integer> list = of(3, 2, 1, 5);
            Integer[] integers = list.toArray(size -> new Integer[1]);
            Assertions.assertArrayEquals(new Integer[]{3}, integers);
        }
    }

    @Nested
    public class Of {
        @Test
        public void shouldAddElementsWhenListIsEmpty() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldAddZeroElementsWhenListIsEmpty() {
            List<Integer> list = of();
            Assertions.assertArrayEquals(new Object[]{}, list.toArray());

        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldEqualsWhenSecondArrayHasNull() {
            List<String> list = createList();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add(null);
            List<String> arrayListSecond = of("A", "B", "C", "D", "E");
            Assertions.assertNotEquals(list, arrayListSecond);
        }

        @Test
        public void shouldEqualsWhenAddEmptyString() {
            List<String> list = of(new MyString(new char[]{}));
            Assertions.assertEquals(list,
                    of(new MyString(new char[]{})));
        }

        @Test
        public void shouldEqualsWhenDifferentTypes() {
            List<Integer> listS = new LinkedList<>();
            Collection<Integer> collection = of(1, 2, 34);
            listS.addAll(collection);


            List<String> list = of(new MyString(new char[]{}));
            Assertions.assertNotEquals(list,
                    of((Object) new Integer[]{1, 3, 3}));
        }
    }

    @Nested
    public class AddAll {
        @Test
        public void shouldAddAllElementsWhenListIsNotEmpty() {
            List<Integer> list = of(6, 7, 8, 9);
            List<Integer> listSecond = of(1, 2, 3, 4, 5);
            list.addAll(listSecond);
            Assertions.assertArrayEquals(new Integer[]{6, 7, 8, 9, 1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldAddAllElementsWhenListIsEmpty() {
            List<Integer> list = of();
            List<Integer> listSecond = of(1, 2, 3, 4, 5);
            list.addAll(listSecond);
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldAddAllElementsWhenWildCard() {
            List<Integer> list = of(999);
            List<Number> listSecond = of(1, 2, 3, 4, 5);
            listSecond.addAll(list);
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 999}, listSecond.toArray());

        }

        @Test
        public void shouldAddAllElementsWhenIndexFirst() {
            List<Integer> list = of(8, 8);
            List<Integer> listSecond = of(1, 2, 3, 4, 5);
            list.addAll(0, listSecond);
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 8, 8}, list.toArray());
        }

        @Test
        public void shouldAddAllElementsWhenIndexMiddle() {
            List<Integer> list = of(8, 8, 9, 10, 11, 12);
            List<Integer> listSecond = of(1, 2, 3, 4, 5);
            list.addAll(3, listSecond);
            Assertions.assertArrayEquals(new Integer[]{8, 8, 9, 1, 2, 3, 4, 5, 10, 11, 12}, list.toArray());
        }

        @Test
        public void shouldAddAllElementsWhenIndexLast() {
            List<Integer> list = of(12);
            List<Integer> listSecond = of(1, 2, 3, 4, 5);
            list.addAll(1, listSecond);
            Assertions.assertArrayEquals(new Integer[]{12, 1, 2, 3, 4, 5}, list.toArray());
        }

        @Test
        public void shouldAddAllElementsWhenIndexAndWildCard() {
            List<Number> list = of(12, 13);
            List<Integer> listSecond = of(5);
            list.addAll(0, listSecond);
            list.addAll(3, listSecond);
            list.addAll(2, listSecond);
            Assertions.assertArrayEquals(new Integer[]{5, 12, 5, 13, 5}, list.toArray());
        }

        @Test
        public void shouldThrowExceptionWhenYouAddCollectionToYourself() {
            List<Number> list = of(12, 13);
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                list.addAll(list);
            });
        }

        @Test
        public void shouldThrowExceptionWhenYouAddCollectionToYourselfWithIndex() {
            List<Number> list = of(12, 13);
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                list.addAll(1, list);
            });
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnSizeWhenListIsEmpty() {
            List<Integer> list = of();
            Assertions.assertEquals(0, list.size());
        }


        @Test
        public void shouldReturnSizeWhenListIsNotEmpty() {
            List<Integer> list = of(1, 2, 3);
            Assertions.assertEquals(3, list.size());
        }

    }

    @Nested
    public class Iterator {
        @Nested
        public class Next {
            @Test
            public void shouldReturnElementWhenListIsNotEmpty() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                Assertions.assertEquals(1, iterator.next());
                Assertions.assertEquals(2, iterator.next());
                Assertions.assertEquals(3, iterator.next());
                Assertions.assertEquals(5, iterator.next());
            }

            @Test
            public void shouldTrowExceptionWhenChangingCollection() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                list.remove(0);
                Assertions.assertThrows(ConcurrentModificationException.class,
                        () -> iterator.hasNext());
            }
        }

        @Test
        public void shouldReturnElementWhenListIsNotEmpty() {
            List<Integer> list = of(1, 2, 3, 5);
            ListIterator<Integer> iterator = list.iterator();
            Assertions.assertEquals(1, iterator.next());
            Assertions.assertEquals(2, iterator.next());
            Assertions.assertEquals(3, iterator.next());
            Assertions.assertEquals(5, iterator.next());
        }

        @Nested
        public class Set {
            @Test
            public void shouldSentElementWhenListIsNotEmpty() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                do {
                    iterator.next();
                    iterator.set(7);
                } while (iterator.hasNext());
                Assertions.assertArrayEquals(new Integer[]{7, 7, 7, 7}, list.toArray());
            }

            @Test
            public void shouldThrowExceptionWhenTryingSetElement() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                Assertions.assertThrows(IllegalStateException.class,
                        () -> {
                            iterator.set(34);
                        });
            }

        }

        @Nested
        public class InsertBefore {
            @Test
            public void shouldInsertElementWhenListIsNotEmpty() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                for (int i = 0; i < 3; i++) {
                    iterator.insertBefore(7);
                }
                Assertions.assertArrayEquals(new Integer[]{7, 7, 7, 1, 2, 3, 5}, list.toArray());
            }

            @Test
            public void shouldTrowExceptionWhenInsertElement() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                Assertions.assertThrows(IllegalStateException.class,
                        () -> {
                            iterator.insertBefore(1);
                        });

            }


        }

        @Nested
        public class Remove {
            @Test
            public void shouldReturnElementWhenListIsNotEmpty() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.remove();
                Assertions.assertArrayEquals(new Integer[]{2, 3, 5}, list.toArray());
                iterator.next();
                iterator.next();
                iterator.remove();
                Assertions.assertArrayEquals(new Integer[]{2, 5}, list.toArray());
                iterator.next();
                iterator.remove();
                Assertions.assertArrayEquals(new Integer[]{2}, list.toArray());
            }

            @Test
            public void shouldTrowExceptionWhenTryingRemoveElement() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                Assertions.assertThrows(IllegalStateException.class,
                        () -> {
                            iterator.remove();
                        });
            }

            @Test
            public void shouldTrowExceptionWhenTryingRemoveElementAfrerRemove() {
                List<Integer> list = of(1, 2, 3, 5);
                ListIterator<Integer> iterator = list.iterator();
                iterator.next();
                iterator.next();
                iterator.next();
                iterator.remove();
                Assertions.assertThrows(IllegalStateException.class,
                        () -> {
                            iterator.remove();
                        });
            }


        }
    }

    @Nested
    public class Sort {
        @Test
        public void shouldSortListWhenListIsNotEmpty() {
            List<Integer> list = of(3, 1, 0, 15, 2, 5);
            list.sort(Comparator.comparingInt(o -> o));
            Assertions.assertArrayEquals(new Integer[]{0, 1, 2, 3, 5, 15}, list.toArray());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnResultWhenLisIsNotEmpty() {
            List<Integer> list = of(3, 2, 1, 3);
            Assertions.assertFalse(list.isEmpty());

        }

        @Test
        public void shouldReturnResultWhenLisIsEmpty() {
            List<Integer> list = of();
            Assertions.assertTrue(list.isEmpty());
        }
    }

    @Nested
    public class Contains {
        @Test
        public void shouldContainElementWhenListHasSpecifiedElement() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            Assertions.assertTrue(list.contains(3));
        }

        @Test
        public void shouldContainElementWhenListHastSpecifiedElement() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            Assertions.assertFalse(list.contains(100));
        }
    }

    @Nested
    public class ContainsAll {
        @Test
        public void shouldContainAllElementsWhenListHasSpecifiedElement() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            List<Integer> listSecond = of(7, 5, 3);
            Assertions.assertTrue(list.containsAll(listSecond));
        }

        @Test
        public void shouldContainAllElementsWhenListHastSpecifiedElement() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            List<Integer> listSecond = of(7, 5, 3, 1, 3, 3, 6, 1);
            Assertions.assertTrue(list.containsAll(listSecond));
        }

        @Test
        public void shouldTrowExceptionWhenTryingUseTheSameList() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            List<Integer> listSecond = of(7, 5, 3, 1, 3, 3, 6, 1);
            Assertions.assertTrue(list.containsAll(listSecond));
        }
    }

    @Nested
    public class RemoveAll {
        @Test
        public void shouldRemoveAllWhenListIsNotEmpty() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            List<Integer> listSecond = of(7, 3, 1, 6, 2, 3, 5);
            list.removeAll(listSecond);
            Assertions.assertTrue(list.isEmpty());
        }

        @Test
        public void shouldRemoveAllWhenListSecondDoestContainSameElements() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            List<Integer> listSecond = of(9, 9, 9, 9, 9, 9, 9);
            list.removeAll(listSecond);
            Assertions.assertArrayEquals(new Integer[]{3, 2, 1, 3, 5, 6, 7}, list.toArray());
        }

        @Test
        public void shouldTrowExceptionWhenUseTheSameCollection() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.removeAll(list));
        }

    }

    @Nested
    public class RemoveIf {
        @Test
        public void shouldRemoveElementWhenListIsNotEmpty() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            list.removeIf(x -> x == 3);
            Assertions.assertArrayEquals(new Integer[]{2, 1, 5, 6, 7}, list.toArray());

        }


        @Test
        public void shouldThrowExceptionWhenRemoveIfIsNull() {
            List<Integer> list = of(3, 2, 1, 3, 5, 6, 7);
            try {
                list.removeIf(null);
            } catch (NullPointerException ex) {
                Assertions.assertEquals(ex.getMessage(), "Predicate is Null");
            }
        }

        @Test
        public void shouldThrowExceptionWhenRemoveElement() {
            List<Integer> list = of(1, 2, 3, 4, 5);
            Assertions.assertThrows(ConcurrentModificationException.class, () -> cycle(list));

        }

        private <T> void cycle(List<T> list) {
            for (T i : list) {
                list.remove(1);
            }
        }
    }


}
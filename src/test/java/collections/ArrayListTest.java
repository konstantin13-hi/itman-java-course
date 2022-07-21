package collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    @Nested
    public class Set {
        @Test
        public void shouldSetWhenArrayIsNotEmpty(){
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            arrayList.add("D");
            arrayList.add("E");
            arrayList.set(2,"CC");
            System.out.println(arrayList.toString());

        }
    }
}
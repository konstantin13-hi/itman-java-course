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

    @Test
    void toArray() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        Assertions.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, arrayList.toArray());
    }

    @Test
    public void remove(){
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.remove(2);
        Assertions.assertArrayEquals(new int[]{1,2,4,5}, arrayList.toArray());

    }

    @Test
    public void equals(){
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        ArrayList arrayListSeocnd = new ArrayList(5);
        arrayListSeocnd.add(1);
        arrayListSeocnd.add(2);
        arrayListSeocnd.add(3);
        arrayListSeocnd.add(4);
        arrayListSeocnd.add(5);
        Assertions.assertTrue( arrayList.equals(arrayListSeocnd));

    }

    @Test
    public void equals2(){
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        ArrayList arrayListSeocnd = new ArrayList(5);
        arrayListSeocnd.add(1);
        arrayListSeocnd.add(2);
        arrayListSeocnd.add(3);
        Assertions.assertFalse( arrayList.equals(arrayListSeocnd));

    }





}
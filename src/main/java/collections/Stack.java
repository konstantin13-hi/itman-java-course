package collections;

import collections.ArrayList;

public class Stack {
    private ArrayList arrayList;

    public Stack(){
        arrayList=new ArrayList();
    }



    public void push(int element) {
        arrayList.add(element);
    }
  public   int peek(){
        int a = arrayList.get(arrayList.size()-1);
        return a;
    }
  public   int pop() {
       return arrayList.remove(arrayList.size()-1);

    }
  public   int size(){
        return arrayList.size();
    }
   public boolean isEmpty(){
        return arrayList.size()==0;
    }

   public int[] toArray(){
      return arrayList.toArray();

    }
}

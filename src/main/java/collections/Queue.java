package collections;


public class Queue {

    LinkedList linkedList = new LinkedList();
    public Queue(){}

    public void offer(int element){

       linkedList.addLast(element);
   }
   public int peek(){
       return linkedList.getFirst();
    }
    public int poll(){
        return linkedList.removeFirst();
    }
   public int size(){
        return linkedList.size();
   }
  public  boolean isEmpty(){

       return linkedList.size()==0;

    }
   public int[] toArray(){
        return linkedList.toArray();
   }
}

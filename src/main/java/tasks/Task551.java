package tasks;

import entities.Node;

public class Task551 {


    public static Node buildLinkedList(){

        Node nodeThird=new Node(37,null);
        Node nodeSecond =new Node(99,nodeThird);
        Node node = new Node(12,nodeSecond);
        nodeThird.setPrev(nodeSecond);
        nodeSecond.setPrev(node);

        return node;
    }
}

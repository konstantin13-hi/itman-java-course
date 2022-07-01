package tasks;

import entities.Node;

public class Task551 {


    public static Node buildLinkedList(){

        Node nodeThird=new Node(37,null,null);
        Node nodeSecond =new Node(99,nodeThird,null);
        Node node = new Node(12,nodeSecond,null);
        nodeThird.setPrev(nodeSecond);
        nodeSecond.setPrev(node);

        return node;
    }
}

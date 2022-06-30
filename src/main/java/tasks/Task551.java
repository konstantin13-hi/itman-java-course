package tasks;

import entities.Node;

public class Task551 {


    public static Node buildLinkedList(){

        Node nodeFirst =new Node(37,null);
        Node nodeSecond =new Node(99,nodeFirst);

        return new Node(12,nodeSecond);
    }
}

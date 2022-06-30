package tasks;

import entities.Node;

public class Task551 {


    public static Node buildLinkedList(){

        Node nodeFisrt =new Node(37,null);
        Node nodeSecond =new Node(99,nodeFisrt);

        return new Node(12,nodeSecond);
    }
}

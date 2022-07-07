package tasks;


public class Task551 {

    public static class Node {
        public void setElement(int element) {
            this.element = element;
        }

        private int element;
        private Node next;
        private Node prev;


        public Node(int element, Node next,Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getPrev() {
            return prev;
        }

        public int getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }


    public static Node buildLinkedList(){
        Node nodeThird= new Node(37, null, null);
       Node nodeSecond = new Node(99, nodeThird, null);
       Node node = new Node(12, nodeSecond, null);
        nodeThird.setPrev(nodeSecond);
        nodeSecond.setPrev(node);

        return node;
    }
}

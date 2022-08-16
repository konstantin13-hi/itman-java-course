package tasks;


public class Task551 {

    public static class Node {
        /**
         * Set element.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param element the first term
         */
        public void setElement(int element) {
            this.element = element;
        }

        private int element;
        private Node next;
        private Node prev;

        /**
         * Create the Node.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param element the first term
         * @param next the first reference
         * @param prev the second reference
         */
        public Node(int element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        /**
         * Set previous node.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param prev the first term
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }

        /**
         * Returns prev node.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @return prev reverence
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Returns element.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @return element
         */
        public int getElement() {
            return element;
        }

        /**
         * Returns nex Node.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @return Node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set next reference.
         *
         * @cpu O(1)
         * @ram O(1)
         *
         * @param next the first term
         */
        public void setNext(Node next) {
            this.next = next;
        }


    }

    /**
     * Returns list with elements 12, 99, 37.
     *
     * @return node
     * @cpu O(1)
     * @ram O(1)
     */
    public static Node buildLinkedList() {
        Node nodeThird = new Node(37, null, null);
        Node nodeSecond = new Node(99, nodeThird, null);
        Node node = new Node(12, nodeSecond, null);
        nodeThird.setPrev(nodeSecond);
        nodeSecond.setPrev(node);
        return node;
    }
}

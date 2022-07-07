package collections;




public class LinkedList {
    private Node head;
    private Node prev;


    public static class Node {
        public void setElement(int element) {
            this.element = element;
        }

        private int element;
        private Node next;
        private Node prev;


        public Node(int element, Node next, Node prev) {
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


    public LinkedList() {

    }

    public LinkedList(LinkedList that) {
        if (that.head != null) {
            int element = that.head.getElement();
            Node node;
            head = new Node(element, null, null);
            prev = head;
            that.head = that.head.getNext();

            while (that.head != null) {
                element = that.head.getElement();
                node = new Node(element, null, prev);
                prev.setNext(node);
                prev = node;
                that.head = that.head.getNext();

            }
        }


    }


    public void addFirst(int element) {
        if (this.head == null) {
            this.head = new Node(element, null, null);
            this.prev = head;
        } else {
            Node node = new Node(element, head, head.getPrev());
            head.setPrev(node);
            head = node;
        }
    }

    public int getFirst() {
        return head.getElement();
    }

    public int removeFirst() {
        int result = head.getElement();
        head = head.getNext();
        return result;
    }

    public void addLast(int element) {
        if (prev == null) {
            prev = new Node(element, null, null);
            head = prev;
        } else {

            Node newNode = new Node(element, null, prev);
            prev.setNext(newNode);
            prev = prev.getNext();

        }

    }

    public int getLast() {
        return prev.getElement();
    }

    public int removeLast() {
        int result = 0;
        Node current = prev;
        result = current.getElement();
        if (prev.getPrev() != null) {
            current.getPrev().setNext(null);
            prev = current.getPrev();
        } else {
            prev = null;
            head = null;
        }


        return result;

    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.getElement());
            // head = head.getNext();
            //  current = current.getNext();
            if (current.getNext() != null) {
                stringBuilder.append(", ");
                current = current.getNext();
            } else {
                //  stringBuilder.append(current.getElement());
                current = current.getNext();
            }


        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public int[] toArray() {
        ArrayList arrayList = new ArrayList();
        Node current = head;
        while (current != null) {
            arrayList.add(current.getElement());
            current = current.getNext();
        }
        return arrayList.toArray();
    }

    public static LinkedList of(int... elements) {
        LinkedList linkedList = new LinkedList();
        for (int element : elements) {
            linkedList.addLast(element);
        }
        return linkedList;
    }

    public boolean equals(LinkedList that) {
        // вопрос про нулл this . вызов будет нул поинт
        if (that == null) {
            return false;
        }
        boolean result=true;
        Node currentThis=this.head;
        Node currentThat=that.head;
        while (currentThat!=null){

           if(currentThat.getElement()!=currentThis.getElement()){
                result=false;
                break;
            }
            currentThis=currentThis.getNext();
            currentThat=currentThat.getNext();
            if((currentThat==null && currentThis!=null)||(currentThat!=null && currentThis==null)){
                result=false;
                break;
            }

        }
        return result;
    }

    public void set(int index, int element) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        current.setElement(element);
    }

    public int get(int index) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        return current.getElement();
    }

    public int remove(int index) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        int result = current.getElement();
      //  Node temp = current;
        if (current.getPrev() == null && current.getNext() == null) {
            head = null;
            prev = null;
        } else {
            if (current.getNext()!=null && current.getPrev()!=null){
                current.getNext().setPrev(current.getPrev());
                current.getPrev().setNext(current.getNext());
                current.setNext(null);
                current.setPrev(null);

            }
            else if (current.getNext()==null && current.getPrev()!=null){
                current.getPrev().setNext(null);
                prev=current.getPrev();
                current.setPrev(null);
            }
            else {
                current.getNext().setPrev(null);
                head=current.getNext();
                current.setNext(null);
            }


        }


        return result;
    }

    public int size() {
        return toArray().length;
    }

}

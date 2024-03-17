package custom.collection;

public class CustomQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = this.head;
        this.head = newNode;
        size++;

        // 비어있는 배열에 addFirst 가 진행된 케이스
        if(this.head.next == null) {
            this.tail = this.head;
        }
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if(head == null)  {
            addFirst(element);
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
        size++;
    }

    public void add(E element) {
        addLast(element);
    }

    public void peek(E element) {
        addLast(element);
    }

    public E poll() {
        if(head == null) return null;

        final E headData = this.head.data;
        // head Last case
        if(this.head.next == this.head) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return headData;
        }

        this.head = this.head.next;
        this.size--;
        return headData;
    }

    public void clear() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public int size() {
        return this.size;
    }

    public void remove() {
        poll();
    }

    public E getElementByIndex(int index) {
        if(index + 1 > size) return null;
        Node<E> x = this.head;
        for(int i = 0; i<index; i ++) {
            x = x.next;
        }
        return x.data;
    }

    private Node<E> getNodeByIndex(int index) {
        if(index + 1 > size) return null;
        Node<E> x = this.head;
        for(int i = 0; i<index; i ++) {
            x = x.next;
        }
        return x;
    }

    public E pollLast() {
        if(this.tail == null) return null;

        final E tailValue = tail.data;

        if(this.tail == this.head) {
            this.tail = null;
            this.head = null;
            this.size = 0;
            return tailValue;
        }

        return removeByIndex(size -1);
    }

    public E removeByIndex(int index) {
        if(index == 0) {
            return poll();
        }
        Node<E> parentNode = getNodeByIndex(index - 1);
        Node<E> toBeDeletedNode = parentNode.next;

        final E returnValue = toBeDeletedNode.data;

        parentNode.next = parentNode.next.next;
        if(toBeDeletedNode == this.tail) {
            parentNode = this.tail;
        }

        toBeDeletedNode = null;
        size --;

        return returnValue;

    }

}

public class SinglyLinkedList<T> {
     private class Node {
        T data;
        Node next;
        Node(T d) { data = d; next = null; }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    public T removeLast() {
        if (head == null) return null;
        if (head.next == null) {
            T val = head.data;
            head = null;
            size--;
            return val;
        }
        Node cur = head;
        while (cur.next.next != null) cur = cur.next;
        T val = cur.next.data;
        cur.next = null;
        size--;
        return val;
    }

    public T getLast() {
        if (head == null) return null;
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        return cur.data;
    }

    public int size() { return size; }

    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
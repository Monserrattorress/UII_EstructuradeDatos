public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeLast() {
        if (head == null) return null;
        if (head == tail) {
            T value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T value = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

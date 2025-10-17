public class DoubleLinkedList {
    
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void printForward() {
        if (head == null) {
            System.out.println("La lista está vacia");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }

    public void remove(int value) {
        if (head == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("El valor " + value + " no se encontro en la lista.");
            return;
        }
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            System.out.println("Se elimino el nodo con valor: " + value);
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        System.out.println("Se elimino el nodo con valor: " + value);
    }

}

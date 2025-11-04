public class App {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Original: ");
        list.print();

        CustomLinkedList evens = new CustomLinkedList();
        CustomLinkedList odds = new CustomLinkedList();

        Node current = list.head;
        while (current != null) {
            if (current.data % 2 == 0) {
                evens.add(current.data);
            } else {
                odds.add(current.data);
            }
            current = current.next;
        }

        System.out.print("Pares: ");
        evens.print();

        System.out.print("Impares: ");
        odds.print();
    }
}
public class App {
    public static void main(String[] args) throws Exception {

        DoubleLinkedList lista = new DoubleLinkedList();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(1);
        lista.add(1);

        System.out.println("Lista antes de eliminar:");
        lista.printForward();

        lista.remove(1);
        lista.remove(4);
        lista.remove(7);

        System.out.println("Lista despues de eliminar:");
        lista.printForward();
    }
}



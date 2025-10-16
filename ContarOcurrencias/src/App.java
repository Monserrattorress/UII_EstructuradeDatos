public class App {
    public static void main(String[] args) throws Exception {
        
        SinglyLinkedList list = new SinglyLinkedList();
        list.printList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(4);

        list.printList();

        System.out.println("El 3 aparece" +    " " + list.Contar(3)    + " veces"); 
    }
    }


public class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;//opcional pero no esta de más para no olvidar que la referencia
                        //al instanciarse es null
    }
}

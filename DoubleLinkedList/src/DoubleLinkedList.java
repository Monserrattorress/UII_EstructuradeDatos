public class DoubleLinkedList {
    
    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head=newNode;
            return;
        }
        Node current=head;
        while (current.next!=null) {
            current=current.next;
        }
        current.next=newNode; //guarda el nuevo nodo
        newNode.previo=current; //marca que en el nuevo nodo, guarda la referencia anterior
    }

    public void printForward(){
        if(head==null){
            System.out.println("la lista esta vacia");
            return;
        }
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("null");
    }

    public void printBackward(){
        if (head==null) {
            System.out.println("la lista esta vacia");
            return;
        }
        Node current=head;
        while (current.next!=null) {
            current=current.next;
        }
        while (current!=null) {
            System.out.println(current.data);
            current=current.previo;
        }
    }
}

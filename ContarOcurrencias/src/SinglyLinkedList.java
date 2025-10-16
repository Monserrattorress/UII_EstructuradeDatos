public class SinglyLinkedList {
    private Node head;

    public void add(int data){
        //Creacion de un nodo
        Node newNode=new Node(data);
        //Virificando si la lista esta vacia, entonces el nuevo nodo es el head
        if(head==null){
        head=newNode;
        return;
        }
        //En caso de que no este vacia la lista
        //vamos a recorrer todos los nodos hasta encontrar el que tenga la referncia (next) es null
    
        Node current=head; //comenzamos desde el primero
        while (current.next!=null) { //next se encarga de recorrer
        current=current.next;
        }
        //se agrega el nuevo nodo en la referencia del ultimo nodo
        current.next=newNode;
    }

    public boolean contains(int data){

        Node current=head;
        while (current!=null) {
            if(current.data==data){
                return true;
        }
        current=current.next;
    }
    return false;
    }

    public void remove(int data){
        if (head==null) return; 
        
        if(head.data==data){
            head=head.next;
        }
        Node current=head;
        while (current.next!=null && current.next.data!= data) { //preguntas si es el valor que buscas y si no se pasa al siguiente
            current=current.next;
        }
        current.next=current.next.next;
        
    }

    public void printList(){
        Node current = head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("null");
    }
    public int Contar(int evaluar){
        int contar = 0;
        Node current = head;
        while (current != null) {
            if(current.data == evaluar){
                contar ++;
            }
            current = current.next;
        }
        return contar;
    }
}

public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int front;//primero en la fila
    private int rear;//para saber en que posicion va el siguiente dato
    private int size;//tamaño de la queue

    //private static final int ARR_TAM=10; //tambien se puede hacer de esta forma

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int tam){
        this.data=new Object[tam];
        this.front=0;
        this.rear=0;
        this.size=0;
    }
    @Override
    public T poll() {
        if(isEmpty()){
            System.out.println("La queue esta vacia");
            return null;
        }
        T result=(T) data[front];//elemento a retirar
        data[front]=null;//limpiamos elemento en la posicion de front
        front=(front+1)%data.length;//calculamos el nuevo frente
        size--;//redicimos el tamaño de la queue
        return result; //devolver el elemento eliminado
    }

    @Override
    public void offer(T element) { //hace que el arreglo sea circular
        //validar si el arreglo esta lleno, lo vamos a incrementar
        this.data[rear]=element; //agregar un nuevo elemento en rear(posicion)
        this.rear=rear+1%data.length;  //calculo de rear, si llega
        this.size++;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("La queue esta vacia");
            return null;
        }
        return (T)data[front];
    }

    @Override
    public void print() {
        StringBuilder sb=new StringBuilder();//es como si  usaras un concatenacion o  acomulador
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[ (front+i)%data.length]);//no s va a dar la pocision que necesitamos
            sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return this.size;//retornar atributo
    } 
}
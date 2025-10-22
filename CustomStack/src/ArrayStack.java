import java.util.Arrays;

public class ArrayStack <T> implements MyStack<T> {

    private Object[] data;
    private int top;

    public ArrayStack(){
        this(10); //hace referencia(linea 9) para ejecutar a un constructor(se invoca) 
    }
    public ArrayStack(int initialCapacity){

        this.data= new Object[initialCapacity];
    }

    @Override
    public void push(T value) {
        //top vale 0
        this.data[top++]=value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
       if(isEmpty()){
        System.out.println("No hay elementos en el stack");
        return null;
       }
       T value=(T) data[--top];//obteniendo el ultimo elemnto del stack
       data[top]=null;
       return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("La pila esta vacia, no puedes obtener nigun elemento");
            return null;
        }
        return(T) data[top];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int size() {
        return top; //regresa el tamaño 
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            data[i] = null;
        }
    }

    //saber cuando esta lleno, agregar capacida y no devuelve nada
    public void addCapacity(){
        if(top==data.length){//si el arreglo esta lleno, vamos a aumentar la capacidad
            int newCap=data.length*2;
            //vamos a crear un nuevo arreglo y pasarle los datos que estan actualmente al nuevo
            data= Arrays.copyOf(data, newCap);
        }
    }
    
    public void printStack(){
        if(isEmpty()){
            System.out.println("La pila esta vacia, no puedes obtener nigun elemento");
            return;
        }
        for (int i = top - 1; i >=0; i--) {
            System.out.println(data[i]);
        }
    }
}
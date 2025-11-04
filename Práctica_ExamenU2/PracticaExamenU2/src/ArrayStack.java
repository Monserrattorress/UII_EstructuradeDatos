import java.util.Arrays;

public class ArrayStack<T> implements MyStack<T> {

    private Object[] data;
    
    private int top;
    //constructor
    public ArrayStack(){
        this(10);
    }
    public ArrayStack(int initiaCapacity){

        this.data = new Object[initiaCapacity];
    }
    @Override
    public void push(T value) {
       
       this.data[top++] = value;

    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("No hay elementos en el Stack");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;

        return value;
    }

    @Override
    public T peek() {
       if(isEmpty()){
        System.out.println("No hay elementos en el Stack");
        return null;
       }

       return (T) data[top];
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
        data[i] = null;
        }
        top = 0;
        System.out.println("EL stack se ha vaciado");
    }
    public void addCapacity(){
        if(top==data.length){
            int newCapacity = data.length*2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @Override
    public void printStack() {
        if(isEmpty()){
            System.out.println("No hay elementos en el Stack");
            return;
        }
        for (int i = top; i >=0; i--) {
            System.out.println(data[i]);
        }
    }
}

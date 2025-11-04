public class ArrayQueue<T> implements IQueue<T> {
    
    private Object[]data;
    
    private int front;
    private int rear;
    
    private int size;
    //constructor
    public ArrayQueue(){
        this(10);
    }
    //constructor arreglo de objetos
    public ArrayQueue(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            System.out.println("No hay elementos en la Queue.");
            return null;
        }
        T result= (T) data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;

        return result;
    }

    @Override
    public void offer(T element) {
        
        this.data[rear] = element;
        this.rear = (rear+1)%data.length;
        size++;
    }

    public void offerFirst(T element) {
        ensureCapacity();
        front = (front - 1 + data.length) % data.length;
        data[front] = element;
        size++;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            Object[] newArr = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[(front + i) % data.length];
            }
            data = newArr;
            front = 0;
            rear = size;
        }
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("No hay elementos en la Queue");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void println() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(data[(front+i)%data.length]);
            sb.append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}
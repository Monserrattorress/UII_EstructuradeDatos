public interface IQueue<T> { //definimos los metodos abstractos de la interfaz
    T poll();
    void offer(T data);
    T peek();
    void print();
    boolean isEmpty();
    int size();
}

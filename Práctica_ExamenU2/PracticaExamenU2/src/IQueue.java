public interface IQueue<T> {
    T poll();
    void offer(T data);
    T peek();
    void println();
    boolean isEmpty();
    int size();
}

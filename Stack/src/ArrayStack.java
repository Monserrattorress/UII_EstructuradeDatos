import java.util.Arrays;

public class ArrayStack<T> {

    private Object[] data;
    private int top;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        data = new Object[capacity];
        top = 0;
    }

    public void push(T value) {
        addCapacity();
        data[top++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public void clear() {
        Arrays.fill(data, null);
        top = 0;
    }

    private void addCapacity() {
        if (top == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
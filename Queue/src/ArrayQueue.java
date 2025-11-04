import java.util.Arrays;
import java.util.Stack;

public class ArrayQueue<T> {

    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T value = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(data, null);
        front = 0;
        rear = 0;
        size = 0;
    }

    public void reverse() {
        Stack<T> stack = new Stack<>();
        while (!isEmpty()) {
            stack.push(dequeue());
        }
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % data.length;
            sb.append(data[index]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
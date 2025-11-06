public class ArrayQueue<T> {
    private Object[] data;
    private int front, rear, size, capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == capacity) expand();
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) return null;
        T value = (T) data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expand() {
        Object[] newData = new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % capacity];
        }
        data = newData;
        front = 0;
        rear = size - 1;
        capacity *= 2;
    }

    public int size() {
        return size;
    }

    public void addFront(T value) {
        if (size == capacity) expand();
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % capacity]);
            if (i < size - 1) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}

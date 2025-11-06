public class ArrayStack<T> {
    private Object[] data;
    private int top;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top + 1 == data.length) expand();
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) return null;
        return (T) data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void expand() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i <= top; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int size() {
        return top + 1;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(data[i]);
            if (i < top) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}
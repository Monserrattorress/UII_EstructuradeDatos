public class App {
    public static void main(String[] args) {
        ArrayQueue<Customer> queue = new ArrayQueue<>();

        queue.enqueue(new Customer(1, "Ana"));
        queue.enqueue(new Customer(2, "Luis"));
        queue.enqueue(new Customer(3, "Maya"));

        System.out.println("Antes de invertir:");
        System.out.println(queue);

        int antes = queue.size();
        queue.reverse();
        int despues = queue.size();

        System.out.println("\nDespues de invertir:");
        System.out.println(queue);
        System.out.println("\nElementos antes = " + antes + "\n elementos despues = " + despues);
    }
}

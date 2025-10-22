public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue<Character> custonQueue=new ArrayQueue<>();

        custonQueue.print();
        custonQueue.offer('A');
        custonQueue.offer('B');
        custonQueue.poll();
        System.out.print("---------------------------");
        custonQueue.print();
        custonQueue.offer('C');
        custonQueue.offer('D');
        custonQueue.offer('E');
        custonQueue.offer('F');
        System.out.print("---------------------------");
        custonQueue.print();
    }
}

public class App {
    public static void main(String[] args) {
        ArrayQueue<Job> queue = new ArrayQueue<>(10);
        ArrayStack<Job> stack = new ArrayStack<>(10);
        SinglyLinkedList<Job> log = new SinglyLinkedList<>();

        String[] commands = {
                "ADD A",
                "ADD B",
                "ADD C",
                "PROCESS 2",
                "PRINT",
                "COMMIT",
                "ROLLBACK 1",
                "ADD D",
                "PROCESS 3",
                "COMMIT",
                "END"
        };

        for (String input : commands) {
            String[] parts = input.trim().split("\\s+");
            String command = parts[0].toUpperCase();

            switch (command) {
                case "ADD":
                    if (parts.length < 2) {
                        System.out.println("Falta ID de trabajo");
                        break;
                    }
                    queue.enqueue(new Job(parts[1]));
                    break;

                case "PROCESS":
                    if (parts.length < 2) {
                        System.out.println("Falta cantidad a procesar");
                        break;
                    }
                    try {
                        int n = Integer.parseInt(parts[1]);
                        for (int i = 0; i < n; i++) {
                            Job job = queue.dequeue();
                            if (job == null) break;
                            stack.push(job);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Numero invalido");
                    }
                    break;

                case "COMMIT":
                    while (!stack.isEmpty()) {
                        log.addLast(stack.pop());
                    }
                    break;

                case "ROLLBACK":
                    if (parts.length < 2) {
                        System.out.println("Falta cantidad a revertir");
                        break;
                    }
                    try {
                        int m = Integer.parseInt(parts[1]);
                        for (int i = 0; i < m; i++) {
                            Job job = log.removeLast();
                            if (job == null) break;
                            queue.addFront(job);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Numero invalido");
                    }
                    break;

                case "PRINT":
                    System.out.println("QUEUE (pendientes): " + queue);
                    System.out.println("STACK (procesando): " + stack);
                    System.out.println("BITACORA (confirmados): " + log);
                    break;

                case "END":
                    System.out.println("=== ESTADO FINAL ===");
                    System.out.println("QUEUE (pendientes): " + queue);
                    System.out.println("STACK (procesando): " + stack);
                    System.out.println("BITACORA (confirmados): " + log);
                    return;

                default:
                    System.out.println("Comando no reconocido: " + input);
            }
        }
    }
}
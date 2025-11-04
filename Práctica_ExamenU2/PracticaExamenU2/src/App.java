import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayQueue<Job> queue = new ArrayQueue<>();
        ArrayStack<Job> stack = new ArrayStack<>();
        SinglyLinkedList<Job> log = new SinglyLinkedList<>();

        System.out.println("Simulador de jobs (lee comandos). Escribe END para terminar.");

        while (true) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;


            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toUpperCase();

            switch (cmd) {
                case "ADD": {
                    if (parts.length < 2 || parts[1].trim().isEmpty()) {
                        System.out.println("Falta ID de trabajo");
                    } else {
                        String id = parts[1].trim();
                        queue.offer(new Job(id));
                    }
                    break;
                }

                case "PROCESS": {
                    if (parts.length < 2 || parts[1].trim().isEmpty()) {
                        System.out.println("PROCESS: falta número de elementos");
                        break;
                    }
                    int n;
                    try {
                        n = Integer.parseInt(parts[1].trim());
                        if (n < 0) {
                            System.out.println("PROCESS: argumento inválido (negativo)");
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("PROCESS: argumento inválido");
                        break;
                    }
                    int toProcess = Math.min(n, queue.size());
                    for (int i = 0; i < toProcess; i++) {
                        Job j = queue.poll();
                        if (j != null) stack.push(j);
                    }
                    break;
                }

                case "COMMIT": {
                    while (!stack.isEmpty()) {
                        Job j = stack.pop();
                        if (j != null) log.addLast(j);
                    }
                    break;
                }

                case "ROLLBACK": {
                    if (parts.length < 2 || parts[1].trim().isEmpty()) {
                        System.out.println("ROLLBACK: falta número de elementos");
                        break;
                    }
                    int m;
                    try {
                        m = Integer.parseInt(parts[1].trim());
                        if (m < 0) {
                            System.out.println("ROLLBACK: argumento inválido (negativo)");
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("ROLLBACK: argumento inválido");
                        break;
                    }
                    int canRevert = Math.min(m, log.size());
                    for (int i = 0; i < canRevert; i++) {
                        Job removed = log.removeLast();
                        if (removed != null) {
                            queue.offerFirst(removed);
                        }
                    }
                    break;
                }

                case "PRINT": {
                    printState(queue, stack, log);
                    break;
                }

                case "END": {
                    System.out.println("=== ESTADO FINAL ===");
                    printState(queue, stack, log);
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Comando no reconocido: " + cmd);
            }
        }

        // por si no hubo END pero se terminó la entrada
        System.out.println("=== ESTADO FINAL ===");
        printState(queue, stack, log);
        sc.close();
    }

    private static void printState(ArrayQueue<Job> q, ArrayStack<Job> s, SinglyLinkedList<Job> log) {
        System.out.println("QUEUE (pendientes): " + q);
        System.out.println("STACK (procesando): " + s);
        System.out.println("BITACORA (confirmados): " + log);
    }
}
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        BubbleSort bs = new BubbleSort();

        System.out.print("Ingresa el numero de calificaciones: ");
        int n = sc.nextInt();

        int[] calificaciones = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa la calificacion " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();
        }

        bs.sort(calificaciones);
    }
}

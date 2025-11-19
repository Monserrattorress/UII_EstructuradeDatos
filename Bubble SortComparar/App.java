
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);

        Bubble sort = new Bubble();

        System.out.println("Ingrese el tamaño del arreglo:");
        int n = teclado.nextInt();

        int[] numeros = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println("Ingrese el número " + (i+1) + ":");
            numeros[i] = teclado.nextInt();
        }
        
        System.out.println("Arreglo original:");
        for(int i = 0; i < n; i++){
            System.out.print(numeros[i] + " ");
        }
        
        System.out.println();
        sort.sort(numeros);

        System.out.println();
         
        int minimo = numeros[0];
        int maximo = numeros[n-1];

        int diferencia = maximo - minimo;

        System.out.println("Elemnento mínimo: " + minimo);
        System.out.println("Elemento máximo: " + maximo);
        System.out.println("Diferencia entre máximo y mínimo: " + diferencia);

       
    }
}

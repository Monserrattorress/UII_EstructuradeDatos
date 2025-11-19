import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        SelectionSort sorter = new SelectionSort();
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Ingrese la cantidad de números: ");
        int n = scanner.nextInt();
        
        int[] arregloOriginal = new int[n];

        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            arregloOriginal[i] = scanner.nextInt();
        }

       
       
        int cantidadPares = 0;
        for (int i = 0; i < n; i++) {
            if (arregloOriginal[i] % 2 == 0) {
                cantidadPares++;
            }
        }
        int cantidadImpares = n - cantidadPares;

        
        int[] pares = new int[cantidadPares];
        int[] impares = new int[cantidadImpares];

        int indicePar = 0;
        int indiceImpar = 0;

        for (int i = 0; i < n; i++) {
            if (arregloOriginal[i] % 2 == 0) {
                pares[indicePar] = arregloOriginal[i];
                indicePar++;
            } else {
                impares[indiceImpar] = arregloOriginal[i];
                indiceImpar++;
            }
        }

       
        sorter.sort(pares);
        sorter.sort(impares);

       
        System.out.println("\n--- RESULTADOS ---");
        
        System.out.print("Arreglo Original: ");
        SelectionSort.imprimirArreglo(arregloOriginal);

        System.out.print("Pares Ordenados:  ");
        SelectionSort.imprimirArreglo(pares);

        System.out.print("Impares Ordenados:");
        SelectionSort.imprimirArreglo(impares);
        
        scanner.close();
    }
    }


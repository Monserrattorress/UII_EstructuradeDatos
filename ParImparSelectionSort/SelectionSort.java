
import java.util.Arrays;

public class SelectionSort {
      
    public void sort(int[] arr){

        int n = arr.length;
        int minIndex;

        for (int i = 0; i < n-1; i++) { 
            
            minIndex = i;

            for (int j = i+1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    
                    minIndex = j; 
                }
                
            }

            int temp = arr[minIndex]; //Guardamos el valor del minimo
            arr[minIndex] = arr[i]; // intercambio, nadamas el valor del actual a la posicion del 
            arr[i] = temp;// en la posicion actual, guardamos el temporal

            
        }

        System.out.println("Arreglo ordenado");
        System.out.println(Arrays.toString(arr));
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
     }

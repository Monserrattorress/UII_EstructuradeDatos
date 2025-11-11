import java.util.Arrays;

public class SelectionSort {
    
    public static void sort(int[] arr) {
        int n = arr.length;
        int minIndex;
        
        for (int i = 0; i < n-1; i++) { //recorremos el arreglo evitando el desbordamiento
            minIndex = i; //suponemos que el minimo es el primer elemento del arreglo no ordenado
            for (int j = i+1; j < n; j++) { //buscamos el minimo en el arreglo no ordenado
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; //seleccionamos el incice del elemento menor
                }
            }
            int temp = arr[minIndex]; //intercambiamos el elemento minimo con el primer elemento del arreglo no ordenado, GUARDAMOS EL VALOR DEL MINIMO
            arr[minIndex] = arr[i];// intercambio, mandamos el valor del actual a la posicion del minimo
            arr[i] = temp; //en la posicion actual, guardamos el valor del minimo
            
        }

        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(arr));
    }
}
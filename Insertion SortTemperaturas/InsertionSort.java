import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {//Comenzamos desde el segundo elemento
            int key = arr[i]; 

            int j = i-1; //Para poder recorrer hacia atras
            while (j>=0 && arr[j]>key) {/*Recorrer la parte ordenada e insertar key en su posición*/
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        System.out.println("Arreglo Ordenado: "+Arrays.toString(arr));
    }
}
public class BubbleSort {
    public void sort(int[] arr) { //arreglo de enteros
        int n = arr.length;
        boolean swapped=false;


        for (int i = 0; i < n-1; i++) { //n-1 por que si no se desborda 
            swapped = false    ; 
            for (int j = 0; j < n-i-1; j++) { //n-i-1 para no comparar los ya ordenados
                if (arr[j] > arr[j+1]) { //si el actual es mayor que el siguiente, el +1 es por el siguiente
                    // se realiza el intercambio
                    int temp = arr[j]; //guardamos el 44
                    arr[j] = arr[j+1]; // el otro valor se cambia de lugar 0-44, se hace el intercambio pero tiene el mismo valor
                    arr[j+1] = temp; //se pasa le valor temporal a la siguiente posicion
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            } //si no hubo intercambios, el arreglo ya esta ordenado
        }
        System.out.println("Arreglo ordenado");
        System.out.println(java.util.Arrays.toString(arr));
    }
}
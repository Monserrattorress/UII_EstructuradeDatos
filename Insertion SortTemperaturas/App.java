import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        InsertionSort insert = new InsertionSort();

        
        int[] temperaturas = {12,40,32,60,14,28,18};
        
        System.out.println("Arreglo Original: "+Arrays.toString(temperaturas));
        
        insert.sort(temperaturas);

        
        int min = temperaturas[0];
        
        int max = temperaturas[temperaturas.length-1];
       
        int rango = max - min;

        System.out.println("Temperatura Máxima: "+max);
        System.out.println("Temperatura Mínima: "+min);
        System.out.println("Rango: "+rango);

        
        int limiteMax = Math.min(3, temperaturas.length);

        System.out.print("Top 3 más altas: ");
        
        for (int i = temperaturas.length - 1; i >= temperaturas.length - limiteMax; i--) {
        System.out.print(temperaturas[i] + " ");
        }
        System.out.println();

        
        int limiteMin = Math.min(3, temperaturas.length);

        System.out.print("Top 3 más bajas: ");
        
        for (int i = 0; i < limiteMin; i++) {
            System.out.print(temperaturas[i] + " ");
        }
    }
}
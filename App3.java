public class App3 {
public class Main{
    public static void main(String[] args) {
        int[][] ArrBi = {
                {1},
                {6, 3, 1},
                {1, 2, 3, 4},
                {0, 5, 3, 0},
                {2, 5, 9},
                {2, 4, 8, 9, 10}
        };
        
        int[][] salida = new int[ArrBi.length][];

        for (int i = 0; i < ArrBi.length; i++) {
            int[] actual = ArrBi[i];

            int contador = 0;
            int primero = 0;
            int ultimo = 0;

            for (int numero : actual) {
                if (contador == 0) {
                    primero = numero;
                }
                ultimo = numero;
                contador++;
            }

            int[] nuevo = new int[contador + 1];

            int j = 0;
            for (int numero : actual) {
                nuevo[j] = numero;
                j++;
            }

            if (contador % 2 == 0) {
                nuevo[j] = primero + ultimo;
            } else {
                nuevo[j] = 0;
            }

            salida[i] = nuevo;
        }
        
        for (int[] fila : salida) {
            System.out.print("{");
            for (int k = 0; k < fila.length; k++) {
                System.out.print(fila[k]);
                if (k < fila.length - 1)
                System.out.print(", ");
            }
            System.out.println("}");
        }
    }
}
}

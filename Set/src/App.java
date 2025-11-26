import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {

        Set<String> set= new TreeSet<>();
                            //HashSet, LinkedHashSet, TreeSet
        set.add("Verde");
        set.add("Rojo");
        set.add("Azul");
        set.add("Verde");//ignora duplicados

        System.out.print(set);//print logra imprimir los datos a la interfaz

        boolean existeVerde=set.contains("Verde");//verificar si existe x objeto dentro del set
        set.remove("Azul");//remover por objeto (recuerda que es por el tipo de dato)

        int tam= set.size();//tamaño del set de datos

        for (String data : set){ //recorrido manual, puede ser tambien con fori o Iterator
            System.out.println("dato en row es:"+data);
        }
        System.out.println("Existe el verde?" +existeVerde);
        System.out.println("El tamaño final es de: " +tam);
    }
}

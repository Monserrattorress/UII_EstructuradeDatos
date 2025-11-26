package com.example.demo.demo.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
//ESTE ES EL CORAZON DE LA APP
//AQUI VIVE LA LOGICA DE NUESTRA app(Melgurges)
@Service
public class SortService {
    public int[] sort(int[] arr){
        int n = arr.length;
        boolean swapped=false;
        //Condicionamos con un for para que no se desborde que recorrra el arreglo
        for (int i = 0; i < n-1; i++) {
            swapped=false;
            //Con un for recorremos el arreglo y con el otro ordenamos todos
            //Esta vez que sea menor a i ya que ahora i tendra un valor despues de haberse recorrido n veces
            for (int j = 0; j < n-1-i; j++) {
                //Evalua si el valor actual es menor al que sigue
                if(arr[j] > arr[j+1]){
                    //Se realiza el intercambio, pasamos el valor original a una variable temporal
                    int temp=arr[j];
                    //La posición actual equivale a la siguiente
                    arr[j]=arr[j+1];
                    //La posición siguiente vale la posición original guardada en la variable temporal
                    arr[j+1]=temp;
                    swapped=true;
                }

            }
            if(!swapped){
                break;
            }
        }
        return arr;
        //Imprimimos el arreglo
        //System.out.println("Arreglo ordenado de menor a mayor");
        //System.out.println(Arrays.toString(arr));
    }
}


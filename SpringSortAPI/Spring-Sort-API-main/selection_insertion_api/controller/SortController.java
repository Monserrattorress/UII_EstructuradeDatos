package com.example.selection_insertion_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.selection_insertion_api.dto.RequestCadena;
import com.example.selection_insertion_api.service.SortService;

@RestController
@RequestMapping("/api/sort")
public class SortController {

    @Autowired
    SortService service;

    @PostMapping("/burbuja")
    public int[] bubbleSort(@RequestBody RequestCadena request) {

        String[] partes = request.getCadena().split(",");
        int[] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) { 

            numeros[i] = Integer.parseInt(partes[i]); 
        }
        return service.sort(numeros);
    }

    @PostMapping("/selection")
    public int[] SelectionSort(@RequestBody RequestCadena request) {

        String[] partes = request.getCadena().split(",");
        for (int i = 0; i < partes.length; i++) { 

            numeros[i] = Integer.parseInt(partes[i]); 
        }
        return service.selectionSort(numeros);
    }

    @PostMapping("/insertion")
    public int[] insertionSort(@RequestBody RequestCadena request) {

        String[] partes = request.getCadena().split(",");
        int[] numeros = new int[partes.length]; 
        for (int i = 0; i < partes.length; i++) { // en cada numero recibido se convierte en un numero entero

            numeros[i] = Integer.parseInt(partes[i]); //guarda en la posicion que estaban los numeros
        }
        return service.insertionSort(numeros);
    }

}
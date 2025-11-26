package com.example.demo.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.dto.ErrorResponse;
import com.example.demo.demo.dto.RequestCadena;
import com.example.demo.demo.service.SortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController//Configuracion de controlador(por tag)
@RequestMapping("/api/sort")//configuracion del endpoint de la API
public class SortController {
    @Autowired
    SortService service;
    @PostMapping("/burbuja")
    // es un generico(no sabemos que le vamos a pasar)
    public ResponseEntity<?> bubbleSort(@RequestBody RequestCadena request) {
        try{
            if (request==null || request.getCadena().isBlank()){
            ErrorResponse error=new ErrorResponse();
            error.setError("la peticion es incorrecta");
            error.setDetail("Necesitamos que llenes los datos del cadena");

            return ResponseEntity.badRequest().body(error);
        }


        String[] partes=request.getCadena().split(",");//recibimos es string y lo convertimos en un arreglo de strings
        int []numeros= new int[partes.length];//declaracion de el arreglo de numero
        for(int i=0;i< partes.length;i++){
            try{
            numeros[i]=Integer.parseInt(partes[i]);
            }
            catch(IllegalArgumentException e){
                ErrorResponse error = new ErrorResponse();
                error.setError("Dato incorrecto ,tiene que ser numerico:"+numeros[i]);
                error.setDetail(e.getMessage());
                return ResponseEntity.badRequest().body(error);
            }
        }
        return ResponseEntity.ok(service.sort(numeros));

        }catch(Exception e){
            ErrorResponse error=new ErrorResponse();
            error.setError("Error general");
            error.setDetail(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
        
    }
    

}

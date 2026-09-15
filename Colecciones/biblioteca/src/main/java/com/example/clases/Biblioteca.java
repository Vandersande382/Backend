package com.example.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import lombok.ToString;
import java.util.Iterator;


@AllArgsConstructor
@Getter
@Setter
@ToString

public class Biblioteca {

    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro){

        libros.add(libro);

    }
    public void listarLibros(){
        for(Libro libro : libros){

            System.out.println(libro);
            System.out.println("");
            
        }
    }

    public void buscarPorAutor(String autorBuscado) {
        Iterator<Libro> it = libros.iterator();

        while(it.hasNext()){
            Libro libroActual = it.next();
            if(libroActual.getAutor().equals(autorBuscado)){
                System.out.println(libroActual);
            }
        }
            
        }
    public void eliminarPorTitulo(String tituloBuscado){
        Iterator<Libro> it = libros.iterator();

        while(it.hasNext()){
            Libro libroActual = it.next();
            if(libroActual.getTitulo().equals(tituloBuscado)){
                it.remove();
            } 
        }
    }
    public void promedioAntiguedad(){
        int acumulador = 0;
        int contador = 0;
        int fechaActual = LocalDate.now().getYear();
        for(Libro libro : libros){

            acumulador += fechaActual - libro.getAnioPublicacion();
            contador++;            
        }

        if(contador==0){

            System.out.println("Division por cero");
        }else{

        int promedio = acumulador/contador;            
        System.out.println("El promedio de antiguedad es de: " + promedio);
        }
    }
}
 

    

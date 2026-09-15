package com.example.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString

public class Libro {

    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;

    public String toString() {

        return "Libro: " + this.titulo + " autor: " + this.autor + " Año de publicacion: " + this.anioPublicacion + " Genero: " + this.genero; 
}
}

package com.example;
import com.example.clases.Libro;

import com.example.clases.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Biblioteca biblioteca = new Biblioteca(new ArrayList<>());

        String[] autores = {"George Orwell", "Jorge Luis Borges", "Gabriel García Márquez", "Franz Kafka", "Virginia Woolf"};
        String[] titulos = {
            "1984", "El Aleph", "Cien años de soledad", "La metamorfosis", "Mrs Dalloway",
            "La guerra del fin del mundo", "El túnel", "El proceso", "Orgullo y prejuicio", "Don Quijote",
            "Ficciones", "Crónica de una muerte anunciada", "La casa de los espíritus", "Ulises", "Moby Dick",
            "Rayuela", "Pedro Páramo", "El extranjero", "El señor de los anillos", "La odisea",
            "Hamlet", "Anna Karenina", "El viejo y el mar", "El nombre de la rosa", "Los miserables",
            "El amor en los tiempos del cólera", "La insoportable levedad del ser", "La sombra del viento", "El lobo estepario",
            "Las aventuras de Sherlock Holmes", "El ruido y la furia", "Madame Bovary", "La ciudad y los perros",
            "A la recherche du temps perdu", "El jardín de los senderos que se bifurcan", "Memoria de mis putas tristes",
            "El tío Tom", "Los pilares de la tierra", "Bajo el volcán", "La letra escarlata", "Eloísa está debajo de un almendro",
            "La tibre del viento", "La vuelta al mundo en 80 días", "Los viajes de Gulliver", "La taberna de los cuatro vientos",
            "Los cuentos de Canterbury", "La prueba", "Los cuadernos de don Rigoberto", "Poema del cante jondo", "La montaña mágica"
        };
        String[] generos = {"Ficción Distópica", "Ficción", "Realismo mágico", "Novela", "Clásico", "Histórico"};

        for (int i = 0; i < 50; i++) {
            String titulo = titulos[i % titulos.length] + " " + (i / titulos.length + 1);
            String autor = autores[i % autores.length];
            int anio = 1940 + (i % 80);
            String genero = generos[i % generos.length];

            biblioteca.agregarLibro(new Libro(titulo, autor, anio, genero));
        }

        biblioteca.listarLibros();

        Scanner sc = new Scanner(System.in);
        int opcion = 12;
        do {
            System.out.println("Ingresar 1 para buscar por autor");
            System.out.println("Ingresar 2 para eliminar por libro");
            System.out.println("Ingresar 0 para salir");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.println("Ingresar autor:");
                String autorBuscado = sc.nextLine();
                biblioteca.buscarPorAutor(autorBuscado);
            } else if (opcion == 2) {
                System.out.println("Ingresar libro:");
                String libroBuscado = sc.nextLine();
                biblioteca.eliminarPorTitulo(libroBuscado);
            }
        } while (opcion != 0);

        sc.close();
    }
}

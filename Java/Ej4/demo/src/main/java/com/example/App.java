package com.example;

import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Ingresar nombre:" );
        String nombre = scanner.nextLine();
        System.out.print( "Ingresar horas trabajadas en el dia:" );
        int horas = scanner.nextInt();
        System.out.print( "Ingresar tareas completadas:" );
        int tareas = scanner.nextInt();
        int puntos;
        int indice;
        if (horas < 8){
            puntos = 5 * (horas - 8);
            indice = (tareas*10) - (puntos);

        } else {
            indice = (tareas*10) + 5;
        }
        System.out.println(nombre);
        System.out.println(horas);
        System.out.println(tareas);
        System.out.println(indice);
    }
}

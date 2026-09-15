//Cleintes app

package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.clases.Cliente;

public class App {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("clientes.csv"))) {
            String linea;
            br.readLine();
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                String nombre = campos[0];
                int dni = Integer.parseInt(campos[1]);
                short edad = Short.parseShort(campos[2]);
                String ocupacion = campos[3];
                int cantidadPosteos = Integer.parseInt(campos[4]);
                float horasEnPlataforma = Float.parseFloat(campos[5]);
                boolean verificado = Boolean.parseBoolean(campos[6]);

                Cliente cliente = new Cliente(nombre, dni, edad, ocupacion, cantidadPosteos, horasEnPlataforma, verificado);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }


        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do{ 
            System.out.println("Ingresar una opcion entre el 1 y 5, ingresar -1 para terminar");
            System.out.println("1- Obtener puntos totales de los clientes");
            System.out.println("2- Obtener los puntos de cada cliente");
            System.out.println("3- Obtener la cantidad de clientes mayores a una edad");
            System.out.println("4- Obtener los primeros 10 clientes");
            System.out.println("5- Obtener la cantidad total de posteos de todos los clientes");
            System.out.println("Ingrese su opcion: ");            
            opcion = sc.nextInt();


            if(opcion == 1){

                int puntosTotales = 0;

                for (Cliente cliente : clientes) {
                puntosTotales += cliente.calcularPuntuacion();
                     }
                System.out.println("puntos totales: " + puntosTotales);
            }
                
            if(opcion == 2){

                int puntosTotales = 0;
        
                for (Cliente cliente : clientes) {
                    
                    System.out.println("El cliente con dni : " + cliente.getDni() +
                                       " tiene: " + cliente.calcularPuntuacion() + 
                                       " puntos");
                }
            }

            if(opcion == 3){
                System.out.println("Ingrese la edad a comparar");
                int edad = sc.nextInt();
                int cantidadMayores = contarMayoresDe(edad, clientes);
                System.out.println("Cantidad de clientes mayores a " + edad + ": " + cantidadMayores);
            }

            if(opcion == 4){
                for (int i = 0; i < 10; i++ ){
                    System.out.println(clientes.get(i));
                }
            }

            if(opcion == 5){
                int totalPosteos = totalPosteos(clientes);
                System.out.println("Cantidad total de posteos de todos los clientes: " + totalPosteos);
            }

        } while(opcion != -1);
    }
    

    public static int contarMayoresDe(int edad, List<Cliente> clientes) {
        int contador = 0;

        for (Cliente cliente : clientes) {
            if (cliente.getEdad() > edad) {
                contador++;
            }
        }

        return contador;
    }

    public static int totalPosteos(List<Cliente> clientes) {
        int acumulador = 0;

        for (Cliente cliente : clientes) {
            acumulador += cliente.getCantidadPosteos();
        }

        return acumulador;
    }

    public static float calcularPuntuacionTodos(List<Cliente> clientes) {
        float puntosTotales = 0;

        for (Cliente cliente : clientes) {
            puntosTotales += cliente.calcularPuntuacion();
        }

        return puntosTotales;
    }
} 
   

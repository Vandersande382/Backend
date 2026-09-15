package com.example.clases;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Cliente {

    private String nombre;
    private int dni; 
    private short edad;
    private String ocupacion;
    private int cantidadPosteos;
    private float horasEnPlataforma;
    private boolean verificado;

   public float calcularPuntuacion(){

        float puntos = 0;

            if(this.edad > 25){
                puntos += this.horasEnPlataforma * 2;
            } else {
                puntos += this.horasEnPlataforma * 3;
            }

            if(this.verificado) {
                puntos += 20;
            }     
            
            return puntos;

        //System.out.println("El cliente con dni : " + this.dni +
        //                  " tiene: " + puntos + " puntos");
        }                        
}

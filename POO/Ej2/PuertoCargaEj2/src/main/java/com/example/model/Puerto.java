package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Puerto {
    private Barco[] barcos;

    public double calcularRecaudacionTotal(){
        double total = 0;
        for (Barco barco : barcos) {
            total += barco.getCostoAlquilerHora() * 15;
        }   

        return total;

    }

    public void mostrarBarcosCapitanesAntiguos() {
        mostrarBarcosCapitanesAntiguos(barcos.length);
    }
    
    public void mostrarBarcosCapitanesAntiguos(int mostrarHasta){
        if (mostrarHasta <= 0){
            return;
        }

        int cantidadMostrada = 0;

        for (Barco barco : barcos) {
            if (barco.getCapitan().getAntiguedad() > 18){

                System.out.println(barco);
                cantidadMostrada++;
                if (cantidadMostrada >= mostrarHasta)
                    break;
            }
        }

    }

    public double promedioToneladasPares() {
        double carga = 0;
        int totalBarcos = 0;

        for ( Barco barco : barcos) {
            if (barco.getNroMuelle() % 2 == 0){
                carga += barco.getCapacidadToneladas();
                totalBarcos++;
            }
        }

        if (totalBarcos == 0)
            return 0;
        
        return carga/totalBarcos;
    }

}

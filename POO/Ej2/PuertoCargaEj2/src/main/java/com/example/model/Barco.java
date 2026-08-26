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

public class Barco {
    private String matricula;
    private int nroMuelle;
    private double capacidadToneladas;
    private double costoAlquilerHora;
    private Capitan capitan;

}

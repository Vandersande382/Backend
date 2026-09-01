package backend.entities.paquetes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paquete {
    protected String descripcion;
    protected double pesoPropio;

    public double calcularCostoAdicional() {
        return 100.0;
    }
}


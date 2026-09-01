package backend.entities.paquetes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Libro extends Paquete {
    private String editorial;
    private boolean esEducativo;

    public Libro(String descripcion, double pesoPropio, String editorial, boolean esEducativo) {
        super(descripcion, pesoPropio);
        this.editorial = editorial;
        this.esEducativo = esEducativo;
    }

    @Override
    public double calcularCostoAdicional() {
        if (esEducativo) {
            return 0.0;
        } else {
            return 150.0;
        }
    }
}


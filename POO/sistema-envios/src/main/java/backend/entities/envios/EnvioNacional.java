package backend.entities.envios;

import backend.entities.paquetes.Paquete;
import backend.exceptions.PesoInvalidoException;

public class EnvioNacional extends Envio {

    private String provincia;

    public EnvioNacional(String id, double pesoBase, double costoEnvio, Paquete paquete, String provincia)
            throws PesoInvalidoException {
        super(id, pesoBase, costoEnvio, paquete);
        this.provincia = provincia;
    }

    @Override
    public double calcularCostoTotal() {
        double total = this.costoEnvio + this.paquete.calcularCostoAdicional();
        if (this.provincia != null && !this.provincia.equalsIgnoreCase("Córdoba")) {
            total += this.costoEnvio * 0.20;
        }
        return total;
    }
}


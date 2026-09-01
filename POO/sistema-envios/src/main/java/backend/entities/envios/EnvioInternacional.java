package backend.entities.envios;

import backend.entities.paquetes.Paquete;
import backend.exceptions.PesoInvalidoException;

public class EnvioInternacional extends Envio {

    private String pais;

    public EnvioInternacional(String id, double pesoBase, double costoEnvio, Paquete paquete, String pais)
            throws PesoInvalidoException {
        super(id, pesoBase, costoEnvio, paquete);
        this.pais = pais;
    }

    @Override
    public double calcularCostoTotal() {
        return this.costoEnvio + this.paquete.calcularCostoAdicional() + 1500.0;
    }
}


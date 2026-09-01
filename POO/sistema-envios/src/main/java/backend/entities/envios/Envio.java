package backend.entities.envios;

import backend.entities.paquetes.Paquete;
import backend.exceptions.PesoInvalidoException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Envio {

    protected String id;
    protected double pesoBase;
    protected double costoEnvio;
    protected Paquete paquete;

    public Envio(String id, double pesoBase, double costoEnvio, Paquete paquete) throws PesoInvalidoException {
        if (paquete == null) {
            throw new PesoInvalidoException("El paquete asociado no puede ser nulo.");
        }

        this.id = id;
        this.pesoBase = pesoBase;
        this.costoEnvio = costoEnvio;
        this.paquete = paquete;

        double pesoTotal = pesoBase + paquete.getPesoPropio();
        if (pesoTotal <= 0) {
            throw new PesoInvalidoException("El peso total del envío debe ser mayor a cero.");
        }
    }

    public abstract double calcularCostoTotal();
}


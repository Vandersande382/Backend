package backend.entities.paquetes;

public class Juguete extends Paquete {

    private int edadRecomendada;
    private boolean requierePilas;

    public Juguete(String descripcion, double pesoPropio, int edadRecomendada, boolean requierePilas) {
        super(descripcion, pesoPropio);
        this.edadRecomendada = edadRecomendada;
        this.requierePilas = requierePilas;
    }

    @Override
    public double calcularCostoAdicional() {
        if (requierePilas) {
            return 500.0;
        } else {
            return 200.0;
        }
    }
}


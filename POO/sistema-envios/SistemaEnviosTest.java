package backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import backend.entities.envios.*;
import backend.entities.paquetes.*;
import backend.exceptions.PesoInvalidoException;
import backend.entities.GestorEnvios;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas Unitarias - Sistema de Gestión de Envíos")
public class SistemaEnviosTest {

    private Paquete paqueteComun;
    private Paquete libroComun;
    private Paquete libroEducativo;
    private Paquete jugueteConPilas;
    private Paquete jugueteSinPilas;

    @BeforeEach
    public void setUp() {
        // Inicialización de paquetes de prueba
        paqueteComun = new Paquete("Caja de Herramientas", 1.0);
        libroComun = new Libro("Novela Policial", 0.5, "Planeta", false);
        libroEducativo = new Libro("Manual de Java", 1.2, "UTN Ediciones", true);
        jugueteConPilas = new Juguete("Auto a Radio Control", 0.8, 8, true);
        jugueteSinPilas = new Juguete("Bloques de Madera", 1.5, 3, false);
    }

    @Test
    @DisplayName("Costo de Envíos Nacionales (Dentro y fuera de Córdoba)")
    public void testCostoEnvioNacional() throws PesoInvalidoException {
        // Envío dentro de Córdoba con Juguete con Pilas (Adicional juguete: $500)
        // Costo base envío: $1000. No hay recargo provincial. Total esperado: 1000 + 500 = 1500
        Envio envioCba = new EnvioNacional("ENV-01", 2.0, 1000.0, jugueteConPilas, "Córdoba");
        assertEquals(1500.0, envioCba.calcularCostoTotal(), 0.001);

        // Envío fuera de Córdoba con Juguete sin Pilas (Adicional juguete: $200)
        // Costo base envío: $1000. Recargo provincial: 20% sobre $1000 ($200). Total esperado: 1000 + 200 + 200 = 1400
        Envio envioBsAs = new EnvioNacional("ENV-02", 2.0, 1000.0, jugueteSinPilas, "Buenos Aires");
        assertEquals(1400.0, envioBsAs.calcularCostoTotal(), 0.001);

        // Envío dentro de Córdoba con Paquete Común (Adicional Paquete Concrete: $100)
        // Costo base envío: $1000. Total esperado: 1000 + 100 = 1100
        Envio envioComun = new EnvioNacional("ENV-01B", 2.0, 1000.0, paqueteComun, "Córdoba");
        assertEquals(1100.0, envioComun.calcularCostoTotal(), 0.001);
    }

    @Test
    @DisplayName("Costo de Envíos Internacionales (Costo base + adicional aduana + paquete)")
    public void testCostoEnvioInternacional() throws PesoInvalidoException {
        // Envío Internacional a España con Libro Educativo (Adicional libro: $0)
        // Costo base envío: $3000. Aduana: $1500. Total esperado: 3000 + 0 + 1500 = 4500
        Envio envioEsp = new EnvioInternacional("ENV-03", 1.5, 3000.0, libroEducativo, "España");
        assertEquals(4500.0, envioEsp.calcularCostoTotal(), 0.001);

        // Envío Internacional a Chile con Libro Común (Adicional libro: $150)
        // Costo base envío: $3000. Aduana: $1500. Total esperado: 3000 + 150 + 1500 = 4650
        Envio envioChl = new EnvioInternacional("ENV-04", 1.5, 3000.0, libroComun, "Chile");
        assertEquals(4650.0, envioChl.calcularCostoTotal(), 0.001);
    }

    @Test
    @DisplayName("Validación de Lanzamiento de PesoInvalidoException")
    public void testPesoInvalidoException() {
        // Intentar crear un envío donde la suma de peso base y peso propio del paquete sea <= 0 (2.0 - 2.0 = 0)
        Paquete paqueteLiviano = new Paquete("Caja Vacía", -2.0);

        assertThrows(PesoInvalidoException.class, () -> {
            new EnvioNacional("ENV-05", 2.0, 500.0, paqueteLiviano, "Córdoba");
        }, "Se esperaba que se lance PesoInvalidoException debido a peso total igual a cero.");
    }
    
    @Test
    @DisplayName("Validación de Control de Duplicados en GestorEnvios (HashMap)")
    public void testControlDuplicados() throws PesoInvalidoException {
        GestorEnvios gestor = new GestorEnvios();
        Envio e1 = new EnvioNacional("ENV-999", 2.0, 1000.0, paqueteComun, "Córdoba");
        Envio e2 = new EnvioNacional("ENV-999", 1.5, 1200.0, libroComun, "Córdoba"); // Mismo ID de envío

        // El primero debe insertarse exitosamente
        assertTrue(gestor.agregarEnvio(e1), "El primer envío debería agregarse correctamente.");
        // El segundo con el mismo ID debe ser rechazado por duplicación
        assertFalse(gestor.agregarEnvio(e2), "El segundo envío con ID repetido debe ser rechazado.");
        // Validamos que el tamaño final del gestor sea exactamente 1
        assertEquals(1, gestor.getEnvios().size(), "El gestor solo debería contener el primer envío.");
    }
}

package pronosticos.unitarias;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pronosticos.CalculadoraPronosticos;

class AlertasTest {

    private final CalculadoraPronosticos calculadora =
            new CalculadoraPronosticos();

    @Test
    @DisplayName("Genera alerta cuando el error supera el umbral")
    void generaAlertaCuandoSuperaElUmbral() {
        assertTrue(calculadora.debeGenerarAlerta(12.0, 10.0));
    }

    @Test
    @DisplayName("Genera alerta cuando el error es igual al umbral")
    void generaAlertaCuandoIgualaElUmbral() {
        assertTrue(calculadora.debeGenerarAlerta(10.0, 10.0));
    }

    @Test
    @DisplayName("No genera alerta cuando el error está bajo el umbral")
    void noGeneraAlertaBajoElUmbral() {
        assertFalse(calculadora.debeGenerarAlerta(7.0, 10.0));
    }

    @Test
    @DisplayName("Rechaza un umbral fuera del rango permitido")
    void rechazaUmbralFueraDelRango() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.debeGenerarAlerta(12.0, 150.0));
    }
}
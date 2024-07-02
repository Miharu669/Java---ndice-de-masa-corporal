package dev.vero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImcTest {

    @Test
    public void testCalculateIMC() {
        double imc = Imc.CalculateIMC(70, 1.58);
        assertEquals(28.04, imc, 0.01);
    }

    @Test
    public void testClassifyIMC() {
        assertEquals("Severe Underweight", Imc.classifyIMC(15.0));
        assertEquals("Moderate Underweight", Imc.classifyIMC(16.5));
        assertEquals("Mild Underweight", Imc.classifyIMC(18.0));
        assertEquals("Normal weight", Imc.classifyIMC(22.0));
        assertEquals("Overweight", Imc.classifyIMC(27.0));
        assertEquals("Mild Obesity", Imc.classifyIMC(32.0));
        assertEquals("Moderate Obesity", Imc.classifyIMC(37.0));
        assertEquals("Morbid Obesity", Imc.classifyIMC(42.0));
    }

    @Test
    public void testCalculateIMCWithInvalidValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Imc.CalculateIMC(-70, 1.58);
        });
        assertEquals("Weight and height must be greater than zero", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Imc.CalculateIMC(70, -1.58);
        });
        assertEquals("Weight and height must be greater than zero", exception.getMessage());
    }
}

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoTest {
    
    private final Calculo calculo = new Calculo();

    @Test
    public void testDescontInss() {

        assertEquals(106.5, calculo.descontoInss(1412.2));
        assertEquals(144.0, calculo.descontoInss(1600.0));
        assertEquals(245.0, calculo.descontoInss(3000.0));
        assertEquals(425.0, calculo.descontoInss(5000.0));
        assertEquals(778.02, calculo.descontoInss(8000.0));
    }

    @Test
    public void testDescontoIr() {

        assertEquals(0.0, calculo.descontoIr(1903.98));
        assertEquals(35.45, calculo.descontoIr(2000.0));
        assertEquals(206.20, calculo.descontoIr(3000.0));
        assertEquals(468.09, calculo.descontoIr(4000.0));
        assertEquals(869.36, calculo.descontoIr(5000.0));

    }

    @Test
    public void testSalarioLiquido() {

        double bruto1 = 1500.0;
        double expectedLiquido1 = calcularSalarioLiquidoEsperado(bruto1);

        calculo.salarioLiquido(bruto1);
        assertEquals(expectedLiquido1, calculo.getLiquido());

        double bruto2 = 2500.0;
        double expectedLiquido2 = calcularSalarioLiquidoEsperado(bruto2);

        calculo.salarioLiquido(bruto2);
        assertEquals(expectedLiquido2, calculo.getLiquido());
    }

    private double calcularSalarioLiquidoEsperado(double bruto) {

        double inss = calculo.descontoInss(bruto);
        double ir = calculo.descontoIr(bruto - inss);
        return bruto - inss - ir;
    }

}

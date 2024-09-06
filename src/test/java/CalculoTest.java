import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoTest {

    // a seguir terão dois métodos que testarão se o valor do desconto do INSS e IR passando valores de salarios brutos para teste
    // e verificando se o valor de desconto calculado bate com o valor esperado e assim pode determinar se a função esta retornando 
    // os descontos certos
    @Test
    public void testDescontInss() {

        // sempre necessário instanciar um objeto da classe que que será testada
        private final Calculo calculo = new Calculo();

        assertEquals(106.5, calculo.descontoInss(1412.2), 0.01);
        assertEquals(144.0, calculo.descontoInss(1600.0), 0.01);
        assertEquals(245.0, calculo.descontoInss(3000.0), 0.01);
        assertEquals(425.0, calculo.descontoInss(5000.0), 0.01);
        assertEquals(778.02, calculo.descontoInss(8000.0), 0.01);
    }

    @Test
    public void testDescontoIr() {

        private final Calculo calculo = new Calculo();

        assertEquals(0.0, calculo.descontoIr(1903.98), 0.01);
        assertEquals(35.45, calculo.descontoIr(2000.0), 0.01);
        assertEquals(206.20, calculo.descontoIr(3000.0), 0.01);
        assertEquals(468.09, calculo.descontoIr(4000.0), 0.01);
        assertEquals(869.36, calculo.descontoIr(5000.0), 0.01);

    }

    // aqui tem um método de teste do método de calcular o salário líquido que vai pegar valores double aleatórios
    // e comparar com o valor que vai vir diratamente da chamada do método, dizendo assim se esta funcionando corretamente ou não
    @Test
    public void testSalarioLiquido() {
        Calculo calculo = new Calculo();

        // Combinações de valores para testar diferentes cenários
        double[] salarios = {1000, 2500, 5000, 10000, Double.MAX_VALUE, Double.MIN_VALUE};

        for (double salario : salarios) {
            calculo.salarioLiquido(salario);
            double inss = calculo.descontoInss(salario);
            double ir = calculo.descontoIr(salario);
            double liquidoEsperado = salario - inss - ir;
            assertEquals(liquidoEsperado, calculo.getLiquido(), 0.01);
        }
    }

}

public class Main {
    public static void main(String[] args) {

        System.out.println("Digite o seu salario bruto:");
        double salarioBruto = Utils.lerDouble();

        Calculo salario = new Calculo();
        salario.salarioLiquido(salarioBruto);
        System.out.println("Salário Líquido: " + salario.getLiquido());
        
    }
}
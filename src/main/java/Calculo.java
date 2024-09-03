public class Calculo {

    public Calculo() {

    }

    public double getLiquido() {
        return liquido;
    }

    public void setLiquido(double liquido) {
        this.liquido = liquido;
    }

    private double liquido;

    public double descontoInss(double bruto){
        double inss = 0;
        if(bruto <= 1412.2){
            inss = bruto * 0.075;
        }else if (bruto <= 2666.68) {
            inss = bruto * 0.09 - 21.18;
        } else if (bruto <= 4000.03) {
            inss = bruto * 0.12 - 101.18;
        } else if (bruto <= 7786.02) {
            inss = bruto * 0.14 - 181.18;
        } else {
            inss = 7786.02 * 0.14 - 181.18;
        }
        return inss;
    }
    public double descontoIr(double bruto) {
        double ir = 0;
        if (bruto <= 1903.98) {
            ir = 0;
        } else if (bruto <= 2826.65) {
            ir = bruto * 0.075 - 142.80;
        } else if (bruto <= 3751.05) {
            ir = bruto * 0.15 - 354.80;
        } else if (bruto <= 4664.68) {
            ir = bruto * 0.225 - 636.13;
        } else {
            ir = bruto * 0.275 - 869.36;
        }
        return ir;
    }

    public void salarioLiquido(double bruto) {
        double inss = descontoInss(bruto);
        double ir = descontoIr(bruto - inss);
        double salario = bruto - inss - ir;
        setLiquido(salario);
    }
}

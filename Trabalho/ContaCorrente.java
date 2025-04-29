public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;
    private double valorTaxaAdm;

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
    public void setValorTaxaAdm(double valorTaxaAdm) {
        this.valorTaxaAdm = valorTaxaAdm;
    }
    public double getValorTaxaAdm() {
        return valorTaxaAdm;
    }

    @Override
    protected double getSaldoDisponivel() {
        return getSaldo() + limiteChequeEspecial;
    }
}
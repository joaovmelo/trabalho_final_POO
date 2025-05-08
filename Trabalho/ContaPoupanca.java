public class ContaPoupanca extends Conta {

    public ContaPoupanca(){}
    
    @Override
    protected double getSaldoDisponivel() {
        return getSaldo();
    }
}
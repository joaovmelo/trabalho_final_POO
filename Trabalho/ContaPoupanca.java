public class ContaPoupanca extends Conta {
    @Override
    protected double getSaldoDisponivel() {
        return getSaldo();
    }
}
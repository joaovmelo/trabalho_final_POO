public class ContaSalario extends Conta {

    private double limSaque;
    private double limTransfer;

    public ContaSalario(double limSaque, double limTransfer) {
        this.limSaque = limSaque;
        this.limTransfer = limTransfer;
    }

    public ContaSalario(){}

    public void setLimSaque(double limSaque){
        this.limSaque = limSaque;
    }
    public void setLimTransfer(double limTransfer){
        this.limTransfer = limTransfer;
    }
    public double getLimTransfer(){
        return this.limTransfer;
    }
    public double getLimSaque(){
        return this.limSaque;
    }

    @Override
    protected double getSaldoDisponivel() {
        return getSaldo();
    }
}
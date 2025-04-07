public class ContaSalario extends Conta{
    private double limSaque;
    private double limTransfer;

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
}

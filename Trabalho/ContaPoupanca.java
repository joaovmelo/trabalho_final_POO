public class ContaPoupanca extends Conta{
    private double rendimentoMesAtual;

    public void setRendimentoMesAtual(double rendimento){
        this.rendimentoMesAtual = rendimento;
    }
    public double getRendimentoMesAtual(){
        return this.rendimentoMesAtual;
    }
}

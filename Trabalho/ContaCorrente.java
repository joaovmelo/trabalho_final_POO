public class ContaCorrente extends Conta{
    private double limChequeEspecial;
    private double valorTaxaAdm;

    public void setLimChequeEspecial(double limChequeEspecial){
        this.limChequeEspecial = limChequeEspecial;
    }
    public void setValorTaxaAdm(double valorTaxa){
        this.valorTaxaAdm = valorTaxa;
    }
    public double getLimChequeEspecial(){
        return this.limChequeEspecial;
    }
    public double getValorTaxaAdm(){
        return this.valorTaxaAdm;
    }
}

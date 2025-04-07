public class AgenciaBancaria {
    private int numAgencia;
    private String nomeAgencia;
    private String adressAgencia;
    private Gerente gerente;

    public void setNumAgencia(int numAgencia){
        this.numAgencia = numAgencia;
    }
    public void setAdressAgencia(String adressAgencia){
        this.adressAgencia = adressAgencia;
    }
    public void setNomeAgencia(String nomeAgencia){
        this.nomeAgencia = nomeAgencia;
    }
    public void setGerente(Gerente gerente){
        this.gerente = gerente;
    }
    public int getNumAgencia(){
        return this.numAgencia;
    }
    public String getNomeAgencia(){
        return this.nomeAgencia;
    }
    public Gerente getGerente(){
        return this.gerente;
    }
    public String getAdressAgencia(){
        return this.adressAgencia;
    }
}

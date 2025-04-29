public class AgenciaBancaria {
    private int numAgencia;
    private String nomeAgencia;
    private Endereco enderecoAgencia;
    private Gerente gerente;

    public AgenciaBancaria() {
        this.numAgencia = 0;
        this.nomeAgencia = "";
        this.enderecoAgencia = null;
        this.gerente = null;
    }

    public AgenciaBancaria(int numAgencia, String nomeAgencia, Endereco endereco, Gerente gerente){
        this.numAgencia = numAgencia;
        this.nomeAgencia = nomeAgencia;
        this.enderecoAgencia = endereco;
        this.gerente = gerente;
    }
    
    public void setEnderecoAgencia(Endereco enderecoAgencia) {
        this.enderecoAgencia = enderecoAgencia;
    }
    public Endereco getEnderecoAgencia() {
        return enderecoAgencia;
    }
    public void setNumAgencia(int numAgencia){
        this.numAgencia = numAgencia;
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
}

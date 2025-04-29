import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//revisar essa classe
//ver o que é enum
public abstract class Conta {
    private boolean estaAtiva;
    private int nroConta;
    private String dataDeAbertura;
    private String dataUltimaMovimentacao;
    private AgenciaBancaria agencia;
    private Cliente cliente;
    private double saldo;
    private String senha;
    private boolean isContaConjunta;
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {
        this.estaAtiva = false;
        this.nroConta = 0;
        this.dataDeAbertura = "";
        this.dataUltimaMovimentacao = "";
        this.agencia = null;
        this.cliente = null;
        this.saldo = 0.0;
        this.senha = "";
        this.transacoes = new ArrayList<>();
        this.isContaConjunta = false;
    }

    public void criacaoContaSolo(Cliente cliente, AgenciaBancaria agencia, boolean isContaConjunta){
        setCliente(cliente);
        setAgencia(agencia);
        
    }

    public void sacar(double valor, String senha) throws SaldoInsuficienteException {
        if (!autenticar(senha)) throw new IllegalArgumentException("Senha inválida");
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > getSaldoDisponivel()) throw new SaldoInsuficienteException("Saldo insuficiente");
        setSaldo(getSaldo() - valor);
        registrarTransacao(valor, Transacao.TipoTransacao.SAQUE);
    }

    public void depositar(double valor, String senha) {
        if (!autenticar(senha)) throw new IllegalArgumentException("Senha inválida");
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        setSaldo(getSaldo() + valor);
        registrarTransacao(valor, Transacao.TipoTransacao.DEPOSITO);
    }

    public double consultarSaldo(String senha) {
        if (!autenticar(senha)) throw new IllegalArgumentException("Senha inválida");
        registrarTransacao(0, Transacao.TipoTransacao.CONSULTA_SALDO);
        return getSaldo();
    }

    public void efetuarPagamento(double valor, String senha) throws SaldoInsuficienteException {
        if (!autenticar(senha)) throw new IllegalArgumentException("Senha inválida");
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        if (valor > getSaldoDisponivel()) throw new SaldoInsuficienteException("Saldo insuficiente");
        setSaldo(getSaldo() - valor);
        registrarTransacao(valor, Transacao.TipoTransacao.PAGAMENTO);
    }

    protected abstract double getSaldoDisponivel();

    private void registrarTransacao(double valor, Transacao.TipoTransacao tipo) {
        transacoes.add(new Transacao(this, new Date(), valor, tipo, Transacao.CanalTransacao.INTERNET_BANKING));
    }

    public double getSaldo() { 
        return this.saldo; 
    }
    protected void setSaldo(double saldo) { 
        this.saldo = saldo; 
    }
    public boolean autenticar(String senha) { 
        return this.senha.equals(senha); 
    }
    public boolean isEstaAtiva() {
        return estaAtiva;
    }

    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(String dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public String getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public void setDataUltimaMovimentacao(String dataUltimaMovimentacao) {
        this.dataUltimaMovimentacao = dataUltimaMovimentacao;
    }

    public AgenciaBancaria getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBancaria agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public boolean getIsContaConjunta(){
        return this.isContaConjunta;
    }
    public void setIsContaConjunta(boolean isContaConjunta) {
        this.isContaConjunta = isContaConjunta;
    }

}
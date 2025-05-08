import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Conta implements Imprimivel{
    private boolean estaAtiva;
    private int nroConta;
    private LocalDate dataDeAbertura;
    private LocalDate dataUltimaMovimentacao;
    private AgenciaBancaria agencia;
    private Cliente cliente;
    private double saldo;
    private String senha;
    private boolean isContaConjunta;
    private List<Transacao> transacoes = new ArrayList<>();
    private List<Cliente> titulares = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public Conta() {
        this.estaAtiva = false;
        this.nroConta = 0;
        this.dataDeAbertura = null;
        this.dataUltimaMovimentacao = null;
        this.agencia = null;
        this.cliente = null;
        this.saldo = 0.0;
        this.senha = "";
        this.transacoes = new ArrayList<>();
        this.isContaConjunta = false;
    }

    public void criacaoContaSolo(List<Cliente> titulares, AgenciaBancaria agencia, String senha){
        setAgencia(agencia);
        this.titulares.add(titulares.get(0));
        setDataDeAbertura(LocalDate.now());
        setNroConta(random.nextInt(999999));
        setEstaAtiva(true);
        setDataUltimaMovimentacao(null);
        setSaldo(0.0);
        setSenha(senha);
        this.transacoes = new ArrayList<>();
        setIsContaConjunta(false);
    }

    public void criacaoContaConjunta(List<Cliente> titulares, AgenciaBancaria agencia, String senha){
        setAgencia(agencia);
        this.titulares.addAll(titulares);
        setDataDeAbertura(LocalDate.now());
        setNroConta(random.nextInt(999999));
        setEstaAtiva(true);
        setDataUltimaMovimentacao(null);
        setSaldo(0.0);
        setSenha(senha);
        this.transacoes = new ArrayList<>();
        setIsContaConjunta(true);
    }

    public void imprimirDados() {
        System.out.println("Conta Número: " + this.nroConta);
        System.out.println("Status da Conta: " + (this.estaAtiva ? "Ativa" : "Inativa"));
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Data de Abertura: " + this.dataDeAbertura);
        System.out.println("Última Movimentação: " + this.dataUltimaMovimentacao);
        System.out.println("Conta Conjunta: " + (this.isContaConjunta ? "Sim" : "Não"));
        System.out.print("Titulares: ");
        for (Cliente titular : this.titulares) {
            System.out.print(titular.getNome() + " ");
        }
        System.out.println();
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
        transacoes.add(new Transacao(this, LocalDate.now(), valor, tipo, Transacao.CanalTransacao.INTERNET_BANKING));
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

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDate localDate) {
        this.dataDeAbertura = localDate;
    }

    public LocalDate getDataUltimaMovimentacao() {
        return dataUltimaMovimentacao;
    }

    public void setDataUltimaMovimentacao(LocalDate data) {
        this.dataUltimaMovimentacao = data;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<Cliente> getTitulares() {
        return titulares;
    }

}
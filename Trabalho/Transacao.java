import java.time.LocalDate;

public class Transacao {
    public enum TipoTransacao { SAQUE, DEPOSITO, CONSULTA_SALDO, PAGAMENTO }
    public enum CanalTransacao { INTERNET_BANKING, CAIXA_ELETRONICO, CAIXA_FISICO }

    private Conta conta;
    private LocalDate data;
    private double valor;
    private TipoTransacao tipo;
    private CanalTransacao canal;

    public Transacao(Conta conta, LocalDate data, double valor, TipoTransacao tipo, CanalTransacao canal) {
        this.conta = conta;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.canal = canal;
    }

    public Transacao(){}

    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData() {
        this.data = LocalDate.now();
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setCanal(CanalTransacao canal) {
        this.canal = canal;
    }
    public TipoTransacao getTipo() {
        return tipo;
    }
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
    public CanalTransacao getCanal() {
        return canal;
    }
}
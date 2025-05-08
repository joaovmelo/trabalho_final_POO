import java.util.Date;

public class Gerente extends Funcionario {
    private static double comissaoPorAgencia = 1000.0;
    private Date dataIngressoGerente;
    private AgenciaBancaria agenciaGerenciada;

    public Gerente(String cpf, int Rg, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento, String sexo, int numeroCarteiraTrabalho,
                   double salarioBase, int anoIngresso, AgenciaBancaria agenciaGerenciada) {
        super(cpf, Rg, nome, endereco, estadoCivil, escolaridade, dataNascimento, sexo, numeroCarteiraTrabalho, "Gerente", salarioBase, anoIngresso);
        this.agenciaGerenciada = agenciaGerenciada;
        this.dataIngressoGerente = new Date();
    }

    public static double getComissaoPorAgencia() {
        return comissaoPorAgencia;
    }

    public static void setComissaoPorAgencia(double comissao) {
        comissaoPorAgencia = comissao;
    }
    public void setDataIngressoGerente(Date dataIngressoGerente) {
        this.dataIngressoGerente = dataIngressoGerente;
    }
    public Date getDataIngressoGerente() {
        return dataIngressoGerente;
    }
    public void setAgenciaGerenciada(AgenciaBancaria agenciaGerenciada) {
        this.agenciaGerenciada = agenciaGerenciada;
    }
    public AgenciaBancaria getAgenciaGerenciada() {
        return agenciaGerenciada;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + comissaoPorAgencia;
    }
}

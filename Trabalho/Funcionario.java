public class Funcionario extends Pessoa{
    private int numCarteiraTrabalho;
    private String cargo;
    private double salarioFuncionario;
    private int anoIngressoEmpresa;

    public int getNumCarteiraTrabalho() {
        return numCarteiraTrabalho;
    }

    public void setNumCarteiraTrabalho(int numCarteiraTrabalho) {
        this.numCarteiraTrabalho = numCarteiraTrabalho;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public int getAnoIngressoEmpresa() {
        return anoIngressoEmpresa;
    }

    public void setAnoIngressoEmpresa(int anoIngressoEmpresa) {
        this.anoIngressoEmpresa = anoIngressoEmpresa;
    }
}

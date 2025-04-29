public class Funcionario extends Pessoa {
    private int numeroCarteiraTrabalho;
    private String cargo;
    private double salarioBase;
    private int anoIngresso;

    public Funcionario(String cpf, int Rg, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento, String sexo, int numeroCarteiraTrabalho,
                       String cargo, double salarioBase, int anoIngresso) {
        super(cpf, Rg, nome, endereco, estadoCivil, escolaridade, dataNascimento, sexo);
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.anoIngresso = anoIngresso;
    }

    public double calcularSalario() {
        int anosNaEmpresa = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - anoIngresso;
        if(anosNaEmpresa > 15){
            return  salarioBase * 1.10;
        }else{
            return salarioBase;
        }
    }
    public void setNumeroCarteiraTrabalho(int numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }
    public int getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public int getAnoIngresso() {
        return anoIngresso;
    }
    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
}
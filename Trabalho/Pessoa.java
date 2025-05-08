import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public abstract class Pessoa {
    private String cpf;
    private int RG;
    private String nome;
    private Endereco endereco;
    private String estadoCivil;
    private String escolaridade;
    private LocalDate dataNascimento;
    private String sexo; 

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Pessoa(String cpf, int RG, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento, String sexo) {
        this.cpf = cpf;
        this.RG = RG;
        this.nome = nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        this.sexo = sexo;
        if(!validadacaoCPF.isCPF(cpf)){
            throw new IllegalArgumentException("CPF não existe");
        }
    }
    public Pessoa(String cpf, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        if(!validadacaoCPF.isCPF(cpf)){
            throw new IllegalArgumentException("CPF não existe");
        }
    }
    public Pessoa(){}
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Endereco getEndereco() {
        return Endereco.getEndereco(endereco);
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
    }
    public void setRG(int rG) {
        RG = rG;
    }
    public int getRG() {
        return RG;
    }
}
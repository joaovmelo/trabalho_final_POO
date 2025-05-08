import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa implements Imprimivel{
    Scanner sc = new Scanner(System.in);
    private List<Conta> contas;

    public Cliente(String cpf, int RG, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento, String sexo) {
        super(cpf, RG, nome, endereco, estadoCivil, escolaridade, dataNascimento, sexo);
        this.contas = new ArrayList<>();
    }
    public Cliente(String cpf, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento){
        super(cpf, nome,endereco, estadoCivil, escolaridade, dataNascimento);
        this.contas = new ArrayList<>();
    }
    public Cliente() {
        super();
        this.contas = new ArrayList<>();
    }
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    public List<Conta> getContas() {
        return contas;
    }

    public String toString(Cliente cliente, Endereco endereco){
        return "Nome: " + cliente.getNome() + 
        "\nCPF: " + validadacaoCPF.imprimeCPF(cliente.getCpf()) + 
        "\nEstado Civil: " + cliente.getEstadoCivil() + 
        "\nEscolaridade: " + cliente.getEscolaridade() + 
        "\nEndereço: " + Endereco.getEndereco(endereco).getRua() + ", " + Endereco.getEndereco(endereco).getBairro() + ", " + Endereco.getEndereco(endereco).getCidade() + 
        "\nData de nascimento: " + cliente.getDataNascimento();
    }

    @Override
    public void imprimirDados() {
        System.out.println(this.toString());
    }
}
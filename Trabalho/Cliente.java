import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    Scanner sc = new Scanner(System.in);
    private List<Conta> contas;

    public Cliente(String cpf, int RG, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento, String sexo) {
        super(cpf, RG, nome, endereco, estadoCivil, escolaridade, dataNascimento, sexo);
        this.contas = new ArrayList<>();
    }
    public Cliente(String cpf, String nome, Endereco endereco, String estadoCivil, String escolaridade, String dataNascimento){
        super(cpf, nome,endereco, estadoCivil, escolaridade, dataNascimento);
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

    public Cliente cadastraCliente(){
        System.out.println("Nome completo: ");
        String nome = sc.nextLine();
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        Endereco endereco = Endereco.cadastraEnderecoCliente();
        System.out.println("Estado Civil: ");
        String estadoCivil = sc.nextLine();
        System.out.println("Escolaridade: ");
        String escolaridade = sc.nextLine();
        System.out.println("Data de nascimento: ");
        String dataNascimento = sc.nextLine();
        Cliente cliente = new Cliente(cpf, nome, endereco, estadoCivil, escolaridade, dataNascimento);
        return cliente;
    }

}
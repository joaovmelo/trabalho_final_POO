import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
public class ClienteService {
    Scanner sc = new Scanner(System.in);
    public Cliente cadastraCliente(){
        System.out.println("Nome completo: ");
        String nome = sc.nextLine();
        String cpf = null;
        boolean cpfValido = false;
        while (!cpfValido) {
            System.out.println("CPF: ");
            cpf = sc.nextLine();
            if (validadacaoCPF.isCPF(cpf)) {
                cpfValido = true;
            } else {
            System.out.println("CPF inválido. Por favor, insira um CPF válido.");
            }
        }
        Endereco endereco = Endereco.cadastraEnderecoCliente();
        System.out.println("Estado Civil: ");
        String estadoCivil = sc.nextLine();
        System.out.println("Escolaridade: ");
        String escolaridade = sc.nextLine();
        String dataNascimento = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.println("Data de nascimento (dd/mm/aaaa): ");
            dataNascimento = sc.nextLine();
            if (validarDataNascimento(dataNascimento)) {
                dataValida = true;
            } else {
                System.out.println("Data inválida. Por favor, insira a data no formato dd/mm/aaaa.");
            }
        }
        return new Cliente(cpf, nome, endereco, estadoCivil, escolaridade, dataNascimento);
    }

    public Conta criacaoConta(List<Cliente> titulares, AgenciaBancaria agencia, String senha, int tipoConta, boolean isConjunta) {
        if (isConjunta && titulares.size() != 2) {
            throw new IllegalArgumentException("Conta conjunta requer dois titulares.");
        } else if (!isConjunta && titulares.size() != 1) {
            throw new IllegalArgumentException("Conta individual requer apenas um titular.");
        }
        Conta conta;
        switch (tipoConta) {
            case 1:
                conta = new ContaCorrente();
                conta.setNomeTipoConta("Conta corrente");
                break;
            case 2:
                conta = new ContaPoupanca();
                conta.setNomeTipoConta("Conta poupança");
                break;
            case 3:
                conta = new ContaSalario();
                conta.setNomeTipoConta("Conta salário");
                break;
            default:
                throw new IllegalArgumentException("Tipo de conta inválido.");
        }
        if (isConjunta) {
            conta.criacaoContaConjunta(titulares, agencia, senha);
            for (Cliente titular : titulares) {
                titular.adicionarConta(conta);
            }
        } else {
            conta.criacaoContaSolo(titulares, agencia, senha);
            for (Cliente titular : titulares) {
                titular.adicionarConta(conta);
            }
        }
        return conta;
    }

    private boolean validarDataNascimento(String dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(dataNascimento, formatter);
            return true; 
        } catch (DateTimeParseException e) {
        return false; 
        }
    }

    public int lerInt(Scanner sc, String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
            }
        }
        return valor;
    }

    public String lerString(Scanner sc, String mensagem) {
        String entrada = "";
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensagem);
            entrada = sc.nextLine().trim();
            if (entrada.matches("[a-zA-ZÀ-ÿ ]+")) { // letras com acento e espaços
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Digite apenas letras.");
            }
        }
        return entrada;
    }
    
    public Double lerDouble(Scanner sc, String mensagem) {
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim().replace(",", "."); 
            try {
                valor = Double.parseDouble(entrada);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números válidos");
            }
        }
        return valor;
    }
}

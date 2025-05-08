import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuDeUsuario implements interfaceDeUsuario{

    Scanner sc = new Scanner(System.in);
    ClienteService clienteService = new ClienteService();
    private List<Cliente> titulares = new ArrayList<>();
    private AgenciaBancaria agencia1;
    private AgenciaBancaria agencia2;
    private boolean isConjunta;
    public MenuDeUsuario(AgenciaBancaria agencia1, AgenciaBancaria agencia2){
        this.agencia1 = agencia1;
        this.agencia2 = agencia2;
    }
    int opcao;
    @Override
    public void menu(){
        do { 
            System.out.println("====Menu principal====");
            System.out.println("1 - Cadastro de Clientes");
            System.out.println("2 - Abertura de Conta");
            System.out.println("3 - Encerramento de conta");
            System.out.println("4 - Fazer login no sistema");
            System.out.println("5 - Fazer logout no sistema");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    cadastraClientes();
                    break;
                case 2:
                    aberturaDeConta();
                    break;
                case 3:
                    encerramentoDeConta();
                    break;
                case 4:
                    login();
                    break;
            }
        } while (opcao != 5);
    }
    @Override
    public void cadastraClientes(){
        System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
        String verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
        if(("S".equals(verificacaoTitularidadeConta))){
            Cliente cliente1 = clienteService.cadastraCliente();
            Cliente cliente2 = clienteService.cadastraCliente();
            titulares.add(cliente1);
            titulares.add(cliente2);
            System.out.println("Clientes " + cliente1.getNome() + " e " + cliente2.getNome() + " cadastrados com sucesso.");
        }else{
            Cliente cliente = clienteService.cadastraCliente();
            titulares.add(cliente);
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
        }
        
    }
    @Override
    public void aberturaDeConta(){
        System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
        String verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
        if("S".equals(verificacaoTitularidadeConta)){
            setIsConjunta(true);
        }else if("N".equals(verificacaoTitularidadeConta)){
            setIsConjunta(false);
        }else{
            System.out.println("Argumento Inválido! Escolha novamente");
            System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
            verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
        }

        System.out.println("Crie uma senha");
        String senha = sc.nextLine();

        System.out.println("Tipos de conta disponíveis no banco");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Salário");
        int tipoConta = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolha uma agência bancária para se afiliar: ");
        System.out.println("1 - Agência Santander - SP");
        System.out.println("2 - Agência Santander UDI - MG");
        int escolhaAgencia = sc.nextInt();
        sc.nextLine();
        AgenciaBancaria agencia = null;
        switch (escolhaAgencia) {
            case 1:
                agencia = agencia1;
                break;
            case 2:
                agencia = agencia2;
                break;
            default:
                System.out.println("Escolha inválida de agência.");
                return;
        }
        Conta conta = clienteService.criacaoConta(titulares, agencia, senha, tipoConta, isConjunta);
        System.out.println("Conta criada com sucesso!");
        imprimirDadosConta(conta);
        titulares.clear();
    }
    
    @Override
    public void login(){

    }

    @Override
    public void encerramentoDeConta(){

    }

    public void setAgencia1(AgenciaBancaria agencia1) {
        this.agencia1 = agencia1;
    }
    public void setAgencia2(AgenciaBancaria agencia2) {
        this.agencia2 = agencia2;
    }
    public AgenciaBancaria getAgencia1() {
        return agencia1;
    }
    public AgenciaBancaria getAgencia2() {
        return agencia2;
    }
    public void setIsConjunta(boolean isConjunta) {
        this.isConjunta = isConjunta;
    }
    public boolean getIsConjunta(){
        return isConjunta;
    }

    public void imprimirDadosConta(Conta conta) {
        System.out.println("=== DADOS DA CONTA CRIADA ===");
    
        // Titulares
        System.out.println("Titular(es):");
        for (Cliente titular : conta.getTitulares()) {
            System.out.println("Nome: " + titular.getNome());
            System.out.println("CPF: " + titular.getCpf());
            System.out.println("------------------------");
        }
    
        // Agência
        System.out.println("Agência: " + conta.getAgencia().getNomeAgencia());
    
        // Senha (apenas para teste — NUNCA fazer isso em produção)
        System.out.println("Senha cadastrada: " + conta.getSenha());
    
        // Tipo de conta
        if (conta instanceof ContaCorrente) {
            System.out.println("Tipo de conta: Conta Corrente");
        } else if (conta instanceof ContaPoupanca) {
            System.out.println("Tipo de conta: Conta Poupança");
        } else if (conta instanceof ContaSalario) {
            System.out.println("Tipo de conta: Conta Salário");
        }
    
        System.out.println("==============================");
    }
}

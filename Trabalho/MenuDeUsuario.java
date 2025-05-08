import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MenuDeUsuario implements interfaceDeUsuario{

    Scanner sc = new Scanner(System.in);
    ClienteService clienteService = new ClienteService();
    private List<Cliente> titulares = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private AgenciaBancaria agencia1;
    private AgenciaBancaria agencia2;
    private boolean isConjunta;
    private Conta contaLogada;
    private Cliente clienteLogado;
    public MenuDeUsuario(AgenciaBancaria agencia1, AgenciaBancaria agencia2){
        this.agencia1 = agencia1;
        this.agencia2 = agencia2;
    }
    int opcao;
    @Override
    public void menu(){
        int opcao;
        do { 
            System.out.println("====Menu principal====");
            System.out.println("1 - Cadastro de Clientes");
            System.out.println("2 - Abertura de Conta");
            System.out.println("3 - Encerramento de conta");
            System.out.println("4 - Fazer login no sistema");
            System.out.println("5 - Encerrar sistema");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    cadastrarClientes();
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
                case 5:
                    break;
                default:
                    System.out.println("Entrada inválida! Tente novamente");
            }
        } while (opcao != 5);
    }
    @Override
    public void cadastrarClientes(){
        System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
        String verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
        while(!"S".equals(verificacaoTitularidadeConta) && !"N".equals(verificacaoTitularidadeConta)){
            System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
            verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
        }
        if(("S".equals(verificacaoTitularidadeConta))){
            setIsConjunta(true);
            Cliente cliente1 = clienteService.cadastraCliente();
            Cliente cliente2 = clienteService.cadastraCliente();
            titulares.add(cliente1);
            titulares.add(cliente2);
            System.out.println("Clientes " + cliente1.getNome() + " e " + cliente2.getNome() + " cadastrados com sucesso.");
        }else{
            setIsConjunta(false);
            Cliente cliente = clienteService.cadastraCliente();
            titulares.add(cliente);
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
        }
        
    }

    @Override
    public void aberturaDeConta() {
        if (titulares == null) {
            List<Cliente> titulares = new ArrayList<>();
            System.out.println("Você ainda não está registrado no sistema. Vamos registrar você antes de abrir sua primeira conta.");
            System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
            String verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
            while(!"S".equals(verificacaoTitularidadeConta) && !"N".equals(verificacaoTitularidadeConta)){
                System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
                verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
            }
            boolean isConjunta;
            if ("S".equals(verificacaoTitularidadeConta)) {
                setIsConjunta(true);
                Cliente cliente1 = clienteService.cadastraCliente();
                Cliente cliente2 = clienteService.cadastraCliente();
                titulares.add(cliente1);
                titulares.add(cliente2);
                System.out.println("Clientes " + cliente1.getNome() + " e " + cliente2.getNome() + " cadastrado com sucesso.");
            } else if ("N".equals(verificacaoTitularidadeConta)) {
                setIsConjunta(false);
                Cliente cliente = clienteService.cadastraCliente();
                titulares.add(cliente);
                System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
            } else {
                System.out.println("Argumento Inválido! Tente novamente.");
                return;
            }
        }else{
            clienteLogado = titulares.get(0);
        }
    
        if (titulares.size() == 1) {
            System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
            String verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
            while(!"S".equals(verificacaoTitularidadeConta) && !"N".equals(verificacaoTitularidadeConta)){
                System.out.println("Abertura de conta será com titularidade conjunta? [S/N]");
                verificacaoTitularidadeConta = sc.nextLine().trim().toUpperCase();
            }
            if ("S".equals(verificacaoTitularidadeConta)) {
               setIsConjunta(true);
            } else if ("N".equals(verificacaoTitularidadeConta)) {
                setIsConjunta(false);
            } else {
                System.out.println("Argumento Inválido! Tente novamente.");
                return;
            }
            if (isConjunta) {
                Cliente segundoTitular = clienteService.cadastraCliente();
                if (segundoTitular.getCpf().equals(clienteLogado.getCpf())) {
                    System.out.println("Não é possível adicionar o mesmo cliente como segundo titular.");
                    return;
                }
                titulares.add(segundoTitular);

            }
        }

        System.out.println("Crie uma senha:");
        String senha = sc.nextLine();
        System.out.println("Tipos de conta disponíveis:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Salário");
        System.out.print("Escolha: ");
        int tipoConta = sc.nextInt();
        if(tipoConta < 1 || tipoConta > 3){
            System.out.println("Escolha um número válido");
            System.out.print("Escolha: ");
            tipoConta = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Escolha uma agência:");
        System.out.println("1 - Agência Santander - SP");
        System.out.println("2 - Agência Santander UDI - MG");
        System.out.print("Escolha: ");
        int escolhaAgencia = sc.nextInt();
        sc.nextLine();
        AgenciaBancaria agencia = switch (escolhaAgencia) {
            case 1 -> agencia1;
            case 2 -> agencia2;
            default -> null;
        };
        if (agencia == null) {
            System.out.println("Escolha inválida de agência.");
            return;
        }
        try {
            Conta conta = clienteService.criacaoConta(titulares, agencia, senha, tipoConta, isConjunta);
            contas.add(conta);
            System.out.println("Conta criada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }
    
    @Override
    public void login() {
        System.out.println("Insira seu CPF para entrar no sistema.");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        while (!validadacaoCPF.isCPF(cpf)) {
            System.out.println("CPF incorreto ou não existe, por favor insira novamente.");
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }
        List<Conta> contasDoCliente = new ArrayList<>();
        for (Conta conta : contas) {
            for (Cliente cliente : conta.getTitulares()) {
                if (cliente.getCpf().equals(cpf)) {
                    contasDoCliente.add(conta);
                    break;
                }
            }
        }
        if (contasDoCliente.isEmpty()) {
            System.out.println("Nenhuma conta encontrada para o CPF informado.");
            menu();
            return;
        }
        System.out.println("====Contas encontradas====");
        for (int i = 0; i < contasDoCliente.size(); i++) {
            Conta conta = contasDoCliente.get(i);
            System.out.println((i + 1) + " - " + conta.getNroConta() + " | " + conta.getAgencia().getNomeAgencia() + " | " + conta.getNomeTipoConta());
        }
    
        System.out.print("Escolha uma conta para fazer login: ");
        int escolhaConta = clienteService.lerInt(sc, "Escolha: ");
        if (escolhaConta < 1 || escolhaConta > contasDoCliente.size()) {
            System.out.println("Escolha inválida.");
            menu();
            return;
        }
        Conta contaSelecionada = contasDoCliente.get(escolhaConta - 1);
        System.out.print("Insira sua senha: ");
        String senha = sc.nextLine();
        if (contaSelecionada.getSenha().equals(senha)) {
            for (Cliente cliente : contaSelecionada.getTitulares()) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteLogado = cliente;
                    System.out.println("Login realizado com sucesso! Bem-vindo, " + cliente.getNome() + "!");
                    menuOperacoes(contaSelecionada);
                    return;
                }
            }
        }
        System.out.println("Dados incorretos. Não foi possível realizar o login.");
        menu();
    }
    
    @Override
    public void menuOperacoes(Conta contaLogada){
        int opcao;
        do { 
            System.out.println("====Menu de operações====");
            System.out.println("1 - Efetuar saque");
            System.out.println("2 - Efetuar depósito");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Efetuar pagamento");
            System.out.println("5 - logout");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1: 
                    Double valor = clienteService.lerDouble(sc, "Valor: ");
                    System.out.print("Insira sua senha: ");
                    String senha = sc.nextLine();
                    try {
                        contaLogada.sacar(valor, senha);
                        System.out.println("Saque realizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro de entrada: " + e.getMessage());
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    valor = clienteService.lerDouble(sc, "Valor: ");
                    System.out.print("Insira sua senha: ");
                    senha = sc.nextLine();
                    try {
                        contaLogada.depositar(valor, senha);
                        System.out.println("Depósito realizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro de entrada: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Insira sua senha: ");
                    senha = sc.nextLine();
                    System.out.println("Saldo na conta: " + contaLogada.consultarSaldo(senha));
                    break;
                case 4:
                    valor = clienteService.lerDouble(sc, "Valor: ");
                    sc.nextLine();
                    System.out.print("Insira sua senha: ");
                    senha = sc.nextLine();
                    try {
                        contaLogada.efetuarPagamento(valor, senha);
                        System.out.println("Pagamento realizado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro de entrada: " + e.getMessage());
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Logout realizado");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
            }
        } while (opcao != 5);
    }

    @Override
    public void encerramentoDeConta(){
        System.out.println("Insira seu CPF para entrar no sistema.");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
    
        while (!validadacaoCPF.isCPF(cpf)) {
            System.out.println("CPF incorreto ou não existe, por favor insira novamente.");
            System.out.print("CPF: ");
            cpf = sc.nextLine();
        }
        List<Conta> contasDoCliente = new ArrayList<>();
        for (Conta conta : contas) {
            for (Cliente cliente : conta.getTitulares()) {
                if (cliente.getCpf().equals(cpf)) {
                    contasDoCliente.add(conta);
                    break;
                }
            }
        }
        if (contasDoCliente.isEmpty()) {
            System.out.println("Nenhuma conta encontrada para o CPF informado.");
            menu();
            return;
        }
        System.out.println("====Contas encontradas====");
        for (int i = 0; i < contasDoCliente.size(); i++) {
            Conta conta = contasDoCliente.get(i);
            System.out.println((i + 1) + " - " + conta.getNroConta() + " | " + conta.getAgencia().getNomeAgencia() + " | " + conta.getNomeTipoConta());
        }
    
        System.out.print("Escolha uma conta para encerrar: ");
        int escolhaConta = sc.nextInt();
        sc.nextLine();
        if (escolhaConta < 1 || escolhaConta > contasDoCliente.size()) {
            System.out.println("Escolha inválida.");
            menu();
            return;
        }
        Conta contaSelecionada = contasDoCliente.get(escolhaConta - 1);
        if(contaSelecionada.getSaldo() > 0){
            System.out.println("Retire todo o saldo da conta antes de encerrar e tente novamente");
            return;
        }
        System.out.print("Insira sua senha: ");
        String senha = sc.nextLine();
        if (contaSelecionada.getSenha().equals(senha)) {
            for (Cliente cliente : contaSelecionada.getTitulares()) {
                if (cliente.getCpf().equals(cpf)) {
                    System.out.println();
                    contaSelecionada.encerrarConta();
                    return;
                }
            }
        }
    }

    public Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente c : titulares) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
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

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }
    public Conta getContaLogada() {
        return contaLogada;
    }
}

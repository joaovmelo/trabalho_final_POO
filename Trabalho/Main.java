public class Main{
    public static void main(String[] args) {
        Endereco enderecoSantanderSP = new Endereco("Rua Simão Borges Filho", "Brooklin Novo", "São Paulo");
        Endereco enderecoSantanderMG_UDI = new Endereco("João Náves de Ávila", "Santa Mônica", "Uberlândia");
        Endereco enderecoGerenteAgencia1 = new Endereco("Rua Acre", "Martins", "Uberlândia");
        Endereco enderecoGerenteAgencia2 = new Endereco("Rua 7 de julho", "Vila Mariana", "São Paulo");
        AgenciaBancaria agencia1 = new AgenciaBancaria(0001, "Banco Santander - SP", enderecoSantanderSP, null);
        AgenciaBancaria agencia2 = new AgenciaBancaria(6666, "Banco Santander - UDI", enderecoSantanderMG_UDI, null);
        Gerente gerenteSantanderMG_UDI = new Gerente("14678612602", 3456785, "Sophia Tavares de Bragança", enderecoGerenteAgencia1, "Solteiro", "Ensino Superior Completo", "01/01/1990", "F", 34554, 8000, 2015, agencia1);
        Gerente gerenteSantanderSP = new Gerente("44494220663", 4586947, "Marco Montes de Santana", enderecoGerenteAgencia2, "Casado", "Ensino Superior Completo", "21/09/1885", "M", 37485, 10000, 2009, agencia2);
        agencia1.setGerente(gerenteSantanderMG_UDI);
        agencia2.setGerente(gerenteSantanderSP);


        MenuDeUsuario menu = new MenuDeUsuario(agencia1, agencia2);
        menu.menu();
    }
}

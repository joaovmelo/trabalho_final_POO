import java.util.Scanner;
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    public Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public static Endereco cadastraEnderecoCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Rua: ");
        String rua = sc.nextLine();
        System.out.println("Bairro: ");
        String bairro = sc.nextLine();
        System.out.println("Cidade: ");
        String cidade = sc.nextLine();
        Endereco endereco = new Endereco(rua, bairro, cidade);
        return endereco;
    }
    public static Endereco getEndereco(Endereco endereco){
        return endereco;
    }
    public String getRua() { 
        return this.rua; 
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() { 
        return this.bairro; 
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() { 
        return this.cidade; 
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

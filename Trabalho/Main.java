import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        //criar um metodo pra fazer toda a parte de impressao do cpf
        Scanner ler = new Scanner(System.in);
        validadacaoCPF validaCPF = new validadacaoCPF();
        String CPF;

        System.out.printf("Informe um CPF: ");
        CPF = ler.next();

        System.out.printf("\nResultado: ");
            // usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
        if (validaCPF.isCPF(CPF) == true)
        System.out.printf("%s\n", validaCPF.imprimeCPF(CPF));
        else System.out.printf("Erro, CPF invalido !!!\n");
        }
}

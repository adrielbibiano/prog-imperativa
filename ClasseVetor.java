import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class ClasseVetor {
    public static final int TAM = 5;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[TAM];
        preencherPessoas(pessoas);
        imprimirPessoas(pessoas);

    
    }

    public static void preencherPessoa(Pessoa p) {
        System.out.println("Digite o nome: ");
        p.nome = input.nextLine();
        System.out.println("Digite a idade: ");
        p.idade = input.nextInt();
        System.out.println("Digite o peso: ");
        p.peso = input.nextDouble();
        System.out.println("Digite a altura: ");
        p.altura = input.nextDouble();
        input.nextLine(); // "joga fora" o ENTER que sobrou do nextDouble() anterior
    }

    public static void preencherPessoas(Pessoa[] vp) {
        for (int i = 0; i < vp.length; i += 1) {
            System.out.printf("============= Preenchimento Pessoa %d =============\n", i + 1);
            vp[i] = new Pessoa();
             preencherPessoa(vp[i]);
        }
    }

    public static void imprimirPessoaCompacto(Pessoa p) {
        System.out.printf("[%10s, %3d anos, %.2f kg, %.2f m, imc = %.2f]\n",
            p.nome, p.idade, p.peso, p.altura, imc(p)
        );
    }

    public static void imprimirPessoas(Pessoa[] vp) {
        System.out.println("\n\n================= Impressão Pessoas =================\n");
        for (int i = 0; i < vp.length; i += 1) {
            System.out.printf("[%d] ", i + 1);
            imprimirPessoaCompacto(vp[i]);
        }
    }

    public static double imc(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }
}

public static int maiorIdade(Pessoa[] vp) {
    int iMaior = 0;
    for (int i = 0; i < vp.length; i += 1){
        if (vp[i].idade > vp[iMaior].idade){
      //if (vp[i].nome.compareTo(vp[iMaior].nome) > 0)      
            iMaior = i;
        }
    }
    return iMaior;

public static int buscaSequencialPorNome(Pessoa[] p, String nome) {
    for( int i=0; i < p.length; i++){
        if(p[i].nomecompareToIgnoreCase(nome)){
        return i;
    }
    return -1;
} 
}
import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Prova01 {

    public static final int TAM = 8;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Pessoa[] pessoas = new Pessoa[TAM];
        int qtd = 0;

        qtd = cadastrarPessoa(pessoas, qtd);
        qtd = cadastrarPessoa(pessoas, qtd);
        qtd = cadastrarPessoa(pessoas, qtd);

        System.out.println("\nLISTA ORIGINAL:");
        imprimirPessoas(pessoas, qtd);

        insertionSortPorNome(pessoas, qtd);
        System.out.println("\nORDENADO POR NOME:");
        imprimirPessoas(pessoas, qtd);

        selectionSortPorIdade(pessoas, qtd);
        System.out.println("\nORDENADO POR IDADE:");
        imprimirPessoas(pessoas, qtd);
    }

    // QUESTÃO 01

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {

        if(qtd == v.length)
            return qtd;

        Pessoa p = new Pessoa();

        System.out.print("Nome: ");
        p.nome = input.nextLine();

        System.out.print("Idade: ");
        p.idade = input.nextInt();

        System.out.print("Peso: ");
        p.peso = input.nextDouble();

        System.out.print("Altura: ");
        p.altura = input.nextDouble();

        input.nextLine();

        v[qtd] = p;

        return qtd + 1;
    }

    public static int buscarNome(Pessoa[] v, int qtd, String nome){

        for(int i = 0; i < qtd; i++) {

            if(v[i].nome.equalsIgnoreCase(nome))
                return i;
        }

        return -1;
    }

    // IMC

    public static double IMC(Pessoa p){
        return p.peso / (p.altura * p.altura);
    }

    // QUESTÃO 02

    public static void imprimirPessoa(Pessoa p) {

        System.out.printf(
            "[%10s, %3d anos, %.2f kg, %.2f m, IMC = %.2f]\n",
            p.nome,
            p.idade,
            p.peso,
            p.altura,
            IMC(p)
        );
    }

    public static void imprimirPessoas(Pessoa[] v, int qtd){

        for(int i = 0; i < qtd; i++) {
            imprimirPessoa(v[i]);
        }
    }

    // QUESTÃO 04

    public static void insertionSortPorNome(Pessoa[] v, int qtd) {

        for(int i = 1; i < qtd; i++) {

            Pessoa chave = v[i];
            int j = i - 1;

            while(j >= 0 &&
                  v[j].nome.compareToIgnoreCase(chave.nome) > 0){

                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = chave;
        }
    }

    // QUESTÃO 05

    public static void selectionSortPorIdade(Pessoa[] v, int qtd) {

        for(int i = 0; i < qtd - 1; i++) {

            int menor = i;

            for(int j = i + 1; j < qtd; j++) {

                if(v[j].idade < v[menor].idade)
                    menor = j;
            }

            Pessoa aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }
}
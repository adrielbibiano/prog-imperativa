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
        cadastrarPessoas(Pessoa[] v, int qtd, String nome);
        imprimirPessoas(pessoas);
        insertionSortPorNome(pessoas, TAM);
        imprimirPessoas(pessoas);
        selectionSortPorIdade(pessoas, TAM);
        imprimirPessoas(pessoas);
        }


private static Scanner input;

//QUESTÃO01

public static int cadastrarPessoa(Pessoa[] v, int qtd){
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
    for(int i=0;i<qtd;i++){
        if(v[i].nome.equalsIgnoreCase(nome)){
            return i;
        }
    }
    return -1;
}

//QUESTÃO02

    public static void imprimirPessoas(Pessoa p) {
        System.out.printf("[%10s, %3d anos, %.2f kg, %.2f m, imc = %.2f]\n",
            p.nome, p.idade, p.peso, p.altura, IMC(p)
        );
    }

//QUESTÃO04

    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i += 1) {
            Pessoa chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].nome.compareTo(chave.nome) > 0) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    
//QUESTÃO05

    public static void selectionSortPorIdade(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd - 1; i += 1) {
            int menor = i;
            for (int j = i + 1; j < qtd; j += 1) {
                if (v[j].idade <v[menor].idade) {
                    menor = j;
                }
            }
            Pessoa aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }
}    
}
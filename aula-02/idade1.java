import java.util.Scanner;

public class Idade1 {
public static Scanner input = new Scanner(System.in);
public static final int ANO_ATUAL = 2026;

public static void main(String[] args) {
     System.out.println("Digite sua idade: ");
    int idade = input.nextInt();
    if (idade < 16) {
        System.out.println("Você não pode votar!");
    } else if (idade < 18) {
        System.out.println("Você pode tirar o título e votar!");
    } else if (idade < 70) {
        System.out.println("Você é obrigador a votar!");
    } else {
        System.out.println("Você não é mais obrigado a votar!");
    }

    int anoNasc = ANO_ATUAL - idade;
    System.out.println("Você nasceu provavelmente em" + anoNasc);

    }
}
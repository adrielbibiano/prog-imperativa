import java.util.Scanner;

public class Idade {
    public static Scanner input = new Scanner(System.in);

    public static void mais(String[] args) {
    System.out.println("Digite sua idade: ");
    int idade = input.nextInt();
    if (idade <= 18) {
        System.out.println("Você pode tirar carteira de motorista!");    
    } else {
        System.out.println("Você não pode tirar carteira de motorista!");
    }
    }
}
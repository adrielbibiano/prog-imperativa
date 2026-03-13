import java.util.Scanner;

public class VetorSemRepeticao {

    public static final int TAM = 10;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numeros = new int[TAM];

        preencher(numeros);
        imprimir(numeros);
    }

    public static void preencher(int[] v) {
        for (int i = 0; i < v.length; i += 1) {

            System.out.print("Digite um número: ");
            int valor = scanner.nextInt();

            if (existe(v, valor, i)) {
                System.out.println("Valor repetido! Recomece a digitação.");

                i = -1; 
                continue;
            }

            v[i] = valor;
        }
    }

    public static boolean existe(int[] v, int valor, int limite) {
        for (int i = 0; i < limite; i += 1) {
            if (v[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public static void imprimir(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
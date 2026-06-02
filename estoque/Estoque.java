import java.util.*;

public class Estoque {

    static List<String[]> produtos = new ArrayList<>();
    // Cada produto: [nome, categoria, qtdEstoque, precoUnitario, qtdMinima]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar");
            System.out.println("5 - Remover elemento");
            System.out.println("6 - Atualizar preco");
            System.out.println("7 - Listagem com subtotal do valor em estoque por categoria");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
    case 1:
        cadastrar(sc);
        break;

    case 2:
        listar();
        break;

    case 3:
        filtrarCategoria(sc);
        break;

    case 4:
        ordenar(sc);
        break;

    case 5:
        remover(sc);
        break;

    case 6:
        atualizarPreco(sc);
        break;

    case 7:
        listagem();
        break;

    case 0:
        System.out.println("Encerrando...");
        break;

    default:
        System.out.println("Opcao invalida!");
}
        }
        sc.close();
    }

    static void cadastrar(Scanner sc) {
        System.out.print("Nome/Descricao: ");
        String nome = sc.nextLine();
        System.out.print("Categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Qtd em estoque: ");
        int qtd = sc.nextInt();
        System.out.print("Preco unitario: ");
        double preco = sc.nextDouble();
        System.out.print("Qtd minima: ");
        int qtdMin = sc.nextInt();
        sc.nextLine();

        produtos.add(new String[]{nome, categoria, String.valueOf(qtd),
                String.valueOf(preco), String.valueOf(qtdMin)});
        System.out.println("Produto cadastrado com sucesso!");
    }

    static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.printf("%-5s %-20s %-15s %-10s %-12s %-10s%n",
                "ID", "Nome", "Categoria", "Qtd", "Preco", "Qtd Min");
        System.out.println("-".repeat(75));
        for (int i = 0; i < produtos.size(); i++) {
            String[] p = produtos.get(i);
            System.out.printf("%-5d %-20s %-15s %-10s R$%-10.2f %-10s%n",
                    i + 1, p[0], p[1], p[2], Double.parseDouble(p[3]), p[4]);
        }
    }

    static void filtrarCategoria(Scanner sc) {
        System.out.print("Categoria: ");
        String cat = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        System.out.printf("%-5s %-20s %-15s %-10s %-12s %-10s%n",
                "ID", "Nome", "Categoria", "Qtd", "Preco", "Qtd Min");
        System.out.println("-".repeat(75));
        for (int i = 0; i < produtos.size(); i++) {
            String[] p = produtos.get(i);
            if (p[1].toLowerCase().equals(cat)) {
                System.out.printf("%-5d %-20s %-15s %-10s R$%-10.2f %-10s%n",
                        i + 1, p[0], p[1], p[2], Double.parseDouble(p[3]), p[4]);
                found = true;
            }
        }
        if (!found) System.out.println("Nenhum produto encontrado para essa categoria.");
    }

    static void ordenar(Scanner sc) {
        System.out.println("Ordenar por:");
        System.out.println("1 - Nome");
        System.out.println("2 - Preco");
        System.out.println("3 - Qtd em estoque");
        System.out.println("4 - Categoria");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        sc.nextLine();

        Comparator<String[]> comp = null;

switch (op) {
    case 1:
        comp = Comparator.comparing(p -> p[0]);
        break;

    case 2:
        comp = Comparator.comparingDouble(
            p -> Double.parseDouble(p[3]));
        break;

    case 3:
        comp = Comparator.comparingInt(
            p -> Integer.parseInt(p[2]));
        break;

    case 4:
        comp = Comparator.comparing(p -> p[1]);
        break;

    default:
        System.out.println("Opcao invalida!");
}

        if (comp != null) {
            produtos.sort(comp);
            System.out.println("Lista ordenada!");
            listar();
        }
    }

    static void remover(Scanner sc) {
        listar();
        if (produtos.isEmpty()) return;
        System.out.print("ID do produto a remover: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id < 1 || id > produtos.size()) {
            System.out.println("ID invalido!");
            return;
        }
        String nome = produtos.get(id - 1)[0];
        produtos.remove(id - 1);
        System.out.println("Produto '" + nome + "' removido com sucesso!");
    }

    static void atualizarPreco(Scanner sc) {
        listar();
        if (produtos.isEmpty()) return;
        System.out.print("ID do produto para atualizar preco: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id < 1 || id > produtos.size()) {
            System.out.println("ID invalido!");
            return;
        }
        System.out.print("Novo preco: ");
        double novoPreco = sc.nextDouble();
        sc.nextLine();
        produtos.get(id - 1)[3] = String.valueOf(novoPreco);
        System.out.println("Preco atualizado com sucesso!");
    }

    static void listagem() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        // Ordenar por categoria
        List<String[]> ordenados = new ArrayList<>(produtos);
        ordenados.sort(Comparator.comparing(p -> p[1]));

        String catAtual = null;
        double subtotal = 0;
        double totalGeral = 0;

        System.out.println("\n===== LISTAGEM POR CATEGORIA =====");
        for (String[] p : ordenados) {
            if (!p[1].equals(catAtual)) {
                if (catAtual != null) {
                    System.out.printf("  Subtotal: R$ %.2f%n", subtotal);
                    System.out.println();
                }
                catAtual = p[1];
                subtotal = 0;
                System.out.println("Categoria: " + catAtual);
                System.out.printf("  %-20s %-10s %-12s%n", "Nome", "Qtd", "Preco Unit.");
                System.out.println("  " + "-".repeat(45));
            }
            double valorItem = Integer.parseInt(p[2]) * Double.parseDouble(p[3]);
            subtotal += valorItem;
            totalGeral += valorItem;
            System.out.printf("  %-20s %-10s R$%-10.2f%n",
                    p[0], p[2], Double.parseDouble(p[3]));
        }
        if (catAtual != null) {
            System.out.printf("  Subtotal: R$ %.2f%n", subtotal);
        }
        System.out.println("\nTotal Geral: R$ " + String.format("%.2f", totalGeral));
    }
}
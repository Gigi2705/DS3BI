import java.util.*;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();  // Alterado para CategoriaDAO
        Scanner sc = new Scanner(System.in);

        System.out.println("1 Inserir | 2 Listar | 3 Atualizar | 4 Deletar");
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do teclado

        switch (opcao) {
            case 1:
                System.out.print("Nome da categoria: ");
                String nome = sc.nextLine();
                Categoria c1 = new Categoria(nome); // Construtor com nome
                dao.inserir(c1);
                break;

            case 2:
                for (Categoria c : dao.listar()) {
                    System.out.println(c.getId() + " | " + c.getNome());
                }
                break;

            case 3:
                System.out.print("ID da categoria: ");
                int idAtualizar = sc.nextInt();
                sc.nextLine(); // Limpa buffer
                System.out.print("Novo nome: ");
                String novoNome = sc.nextLine();
                Categoria c2 = new Categoria(novoNome);
                c2.setId(idAtualizar);
                dao.atualizar(c2);
                break;

            case 4:
                System.out.print("ID da categoria a deletar: ");
                int idDeletar = sc.nextInt();
                dao.deletar(idDeletar);
                break;

            default:
                System.out.println("Opção inválida.");
        }

        sc.close();
    }
}
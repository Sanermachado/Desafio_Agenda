import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AgendaTelefonica agenda = new AgendaTelefonica();
    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    buscarContato();
                    break;
                case 4:
                    atualizarContato();
                    break;
                case 5:
                    listarContatos();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
    private static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Adicionar novo contato");
        System.out.println("2. Remover contato");
        System.out.println("3. Buscar contato");
        System.out.println("4. Atualizar contato");
        System.out.println("5. Listar todos os contatos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
    private static void adicionarContato() {
        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();

        // Verifica se o contato já existe
        if (agenda.buscarContato(nome) != null) {
            System.out.println("Contato com esse nome já existe na agenda.");
            return;
        }
        System.out.print("Número de telefone: ");
        String numeroTelefone = scanner.nextLine();

        Contato novoContato = new Contato(nome, numeroTelefone);
        agenda.adicionarContato(novoContato);
        System.out.println("Contato adicionado com sucesso.");
    }
    private static void removerContato() {
        System.out.print("Nome do contato a ser removido: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            agenda.removerContato(nome);
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
    private static void buscarContato() {
        System.out.print("Nome do contato a ser buscado: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: Nome: " + contato.getNome() + ", Telefone: " + contato.getNumeroTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
    private static void atualizarContato() {
        System.out.print("Nome do contato a ser atualizado: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo número de telefone: ");
            String novoNumero = scanner.nextLine();
            Contato novoContato = new Contato(novoNome, novoNumero);
            agenda.atualizarContato(nome, novoContato);
            System.out.println("Contato atualizado com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
    private static void listarContatos() {
        System.out.println("=== Lista de Contatos ===");
        agenda.listarContatos();
    }
}

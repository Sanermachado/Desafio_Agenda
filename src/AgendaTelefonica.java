import java.util.ArrayList;
import java.util.List;
public class AgendaTelefonica {
    private List<Contato> contatos;
    public AgendaTelefonica() {
        this.contatos = new ArrayList<>();
    }
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }
    public void removerContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equals(nome));
    }
    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }
    //teste commit
    public void atualizarContato(String nome, Contato novoContato) {
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            if (contato.getNome().equals(nome)) {
                contatos.set(i, novoContato);
                return;
            }
        }
    }
    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getNumeroTelefone());
        }
    }
}

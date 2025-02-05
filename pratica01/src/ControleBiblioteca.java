import java.util.ArrayList;
import java.util.List;

public class ControleBiblioteca {
    private List<Publicacao> publicacoes;

    public ControleBiblioteca() {
        publicacoes = new ArrayList<>();
        System.out.println("ControleBiblioteca iniciado");
    }

    public void adicionarPublicacao(Publicacao publicacao) {
        if (publicacao != null) {
            publicacoes.add(publicacao);
            System.out.println("Publicação adicionada com sucesso:");
            System.out.println(publicacao.getInfo());
            System.out.println("Total de publicações: " + publicacoes.size());
        } else {
            System.out.println("Erro: Tentativa de adicionar publicação nula");
        }
    }

    public List<Publicacao> listarPublicacoes() {
        System.out.println("Listando publicações. Total: " + publicacoes.size());
        return new ArrayList<>(publicacoes);
    }

    public void imprimirTodasPublicacoes() {
        System.out.println("\n=== TODAS AS PUBLICAÇÕES ===");
        if (publicacoes.isEmpty()) {
            System.out.println("Nenhuma publicação cadastrada");
        } else {
            for (Publicacao pub : publicacoes) {
                System.out.println(pub.getInfo());
            }
        }
        System.out.println("=========================\n");
    }
}


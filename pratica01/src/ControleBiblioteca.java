import java.util.ArrayList;
import java.util.List;

public class ControleBiblioteca {
    private List<Publicacao> publicacoes;

    public ControleBiblioteca() {
        publicacoes = new ArrayList<>();
    }

    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
    }

    public List<Publicacao> listarPublicacoes() {
        return new ArrayList<>(publicacoes);
    }
}


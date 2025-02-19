import javax.swing.*;
import java.awt.*;

public class BibliotecaGUI {
    private ControleBiblioteca controle;
    private JFrame frameMain;
    private JTextArea areaListagem;

    public BibliotecaGUI() {
        controle = new ControleBiblioteca();
        criarInterfacePrincipal();
    }

    private void criarInterfacePrincipal() {
        frameMain = new JFrame("Biblioteca");
        frameMain.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Livros", new FormularioLivro(controle, v -> atualizarListagem()));
        tabbedPane.addTab("Revistas", new FormularioRevista(controle, v -> atualizarListagem()));
        tabbedPane.addTab("Vídeos", new FormularioVideo(controle, v -> atualizarListagem()));

        frameMain.add(tabbedPane, BorderLayout.WEST);

        areaListagem = new JTextArea(20, 40);
        areaListagem.setEditable(false);
        frameMain.add(new JScrollPane(areaListagem), BorderLayout.CENTER);

        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);

        atualizarListagem();
    }

    private void atualizarListagem() {
        StringBuilder sb = new StringBuilder("=== ITENS BIBLIOGRÁFICOS ===\n\n");

        for (ItemBibliografico item : controle.listarItens()) {
            sb.append(item.getInfo()).append("\n\n");
        }

        areaListagem.setText(sb.toString());
    }

    public static void main(String[] args) {
        new BibliotecaGUI();
    }
}
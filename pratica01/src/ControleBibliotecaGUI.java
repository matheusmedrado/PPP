import javax.swing.*;
import java.awt.*;

public class ControleBibliotecaGUI {
    private ControleBiblioteca controle;
    private JFrame frameLivros;
    private JFrame frameRevistas;
    private JFrame frameListagem;
    private JTextArea areaListagem;
    
    public ControleBibliotecaGUI() {
        controle = new ControleBiblioteca();
        criarTelaLivros();
        criarTelaRevistas();
        criarTelaListagem();
    }

    private void criarTelaLivros() {
        frameLivros = new JFrame("Livros");
        frameLivros.setLayout(new GridLayout(5, 2));
        
        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtAno = new JTextField();
        
        frameLivros.add(new JLabel("Título:"));
        frameLivros.add(txtTitulo);
        frameLivros.add(new JLabel("Autor:"));
        frameLivros.add(txtAutor);
        frameLivros.add(new JLabel("Ano:"));
        frameLivros.add(txtAno);
        
        JButton btnIncluir = new JButton("Incluir");
        JButton btnRevistas = new JButton("Revistas");
        JButton btnListagem = new JButton("Listagem");
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnRevistas);
        painelBotoes.add(btnListagem);
        
        frameLivros.add(painelBotoes);
        
        btnIncluir.addActionListener(e -> {
            if (txtTitulo.getText().trim().isEmpty() || 
                txtAutor.getText().trim().isEmpty() || 
                txtAno.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frameLivros, "Por favor, preencha todos os campos!");
                return;
            }

            Livro livro = new Livro(
                txtTitulo.getText().trim(),
                "Editora",
                Integer.parseInt(txtAno.getText().trim()),
                txtAutor.getText().trim()
            );
            
            controle.adicionarPublicacao(livro);
            limparCampos(txtTitulo, txtAutor, txtAno);
            atualizarListagem();
        });
        
        btnRevistas.addActionListener(e -> {
            frameLivros.setVisible(false);
            frameRevistas.setVisible(true);
        });
        
        configurarBotaoListagem(btnListagem);
        
        frameLivros.setSize(400, 200);
        frameLivros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLivros.setVisible(true);
    }

    private void criarTelaRevistas() {
        frameRevistas = new JFrame("Revistas");
        frameRevistas.setLayout(new GridLayout(6, 2));
        
        JTextField txtTitulo = new JTextField();
        JTextField txtOrg = new JTextField();
        JTextField txtVol = new JTextField();
        JTextField txtNro = new JTextField();
        JTextField txtAno = new JTextField();
        
        frameRevistas.add(new JLabel("Título:"));
        frameRevistas.add(txtTitulo);
        frameRevistas.add(new JLabel("Org.:"));
        frameRevistas.add(txtOrg);
        frameRevistas.add(new JLabel("Vol.:"));
        frameRevistas.add(txtVol);
        frameRevistas.add(new JLabel("Nro.:"));
        frameRevistas.add(txtNro);
        frameRevistas.add(new JLabel("Ano:"));
        frameRevistas.add(txtAno);
        
        JButton btnIncluir = new JButton("Incluir");
        JButton btnLivros = new JButton("Livros");
        JButton btnListagem = new JButton("Listagem");
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnLivros);
        painelBotoes.add(btnListagem);
        
        frameRevistas.add(painelBotoes);
        
        btnIncluir.addActionListener(e -> {
            if (txtTitulo.getText().trim().isEmpty() || 
                txtOrg.getText().trim().isEmpty() || 
                txtVol.getText().trim().isEmpty() || 
                txtNro.getText().trim().isEmpty() || 
                txtAno.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frameRevistas, "Por favor, preencha todos os campos!");
                return;
            }

            Revista revista = new Revista(
                txtTitulo.getText().trim(),
                "Editora",
                Integer.parseInt(txtAno.getText().trim()),
                "ISSN",
                Integer.parseInt(txtNro.getText().trim()),
                txtOrg.getText().trim(),
                Integer.parseInt(txtVol.getText().trim())
            );
            
            controle.adicionarPublicacao(revista);
            limparCampos(txtTitulo, txtOrg, txtVol, txtNro, txtAno);
            atualizarListagem();
        });
        
        btnLivros.addActionListener(e -> {
            frameRevistas.setVisible(false);
            frameLivros.setVisible(true);
        });
        
        configurarBotaoListagem(btnListagem);
        
        frameRevistas.setSize(400, 250);
        frameRevistas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void criarTelaListagem() {
        frameListagem = new JFrame("Listagem");
        areaListagem = new JTextArea(20, 40);
        areaListagem.setEditable(false);
        areaListagem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(areaListagem);
        frameListagem.add(scrollPane);
        
        frameListagem.setSize(500, 400);
        frameListagem.setLocation(410, 0);
        frameListagem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameListagem.setVisible(true);
        
        atualizarListagem();
    }

    private void atualizarListagem() {
        java.util.List<Publicacao> pubs = controle.listarPublicacoes();
        
        StringBuilder sb = new StringBuilder();
        sb.append("=================== LISTAGEM ===================\n\n");
        
        if (pubs.isEmpty()) {
            sb.append("         Nenhuma publicação cadastrada.\n");
        } else {
            for (Publicacao pub : pubs) {
                if (pub instanceof Livro) {
                    sb.append("----------------------------------------\n");
                    sb.append(String.format("Livro: %s\n", pub.titulo));
                    sb.append(String.format("Autor: %s\n", ((Livro) pub).getAutor()));
                    sb.append(String.format("Ano: %d\n", pub.ano));
                } else if (pub instanceof Revista) {
                    Revista rev = (Revista) pub;
                    sb.append("----------------------------------------\n");
                    sb.append(String.format("Revista: %s\n", rev.titulo));
                    sb.append(String.format("Organização: %s\n", rev.getOrganizador()));
                    sb.append(String.format("Volume: %d\n", rev.getVolume()));
                    sb.append(String.format("Número: %d\n", rev.getNumero()));
                    sb.append(String.format("Ano: %d\n", rev.ano));
                }
                sb.append("----------------------------------------\n\n");
            }
        }
        
        if (areaListagem != null) {
            areaListagem.setFont(new Font("Monospaced", Font.PLAIN, 12));
            areaListagem.setText(sb.toString());
            frameListagem.setVisible(true);
            frameListagem.toFront();
        }
    }

    private void configurarBotaoListagem(JButton btnListagem) {
        btnListagem.addActionListener(e -> {
            atualizarListagem();
            frameListagem.setVisible(true);
            frameListagem.toFront();
        });
    }

    private void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}
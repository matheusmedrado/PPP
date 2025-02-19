import javax.swing.*;
import java.util.function.Consumer;

public class FormularioVideo extends FormularioBase {
    private JTextField txtAutor;
    private JTextField txtDuracao;

    public FormularioVideo(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtAutor = new JTextField();
        txtDuracao = new JTextField();

        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Duração (min):"));
        add(txtDuracao);

        JButton btnAdicionar = new JButton("Adicionar Vídeo");
        btnAdicionar.addActionListener(e -> adicionarVideo());
        add(btnAdicionar);
    }

    private void adicionarVideo() {
        if (!validarCamposBasicos() || txtAutor.getText().trim().isEmpty() ||
                txtDuracao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico video = criarItem();
            controle.adicionarItem(video);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e duração devem ser números!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAno.setText("");
        txtDuracao.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Video(
                txtTitulo.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtAutor.getText().trim(),
                Integer.parseInt(txtDuracao.getText().trim())
        );
    }
}

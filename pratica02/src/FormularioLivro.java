import javax.swing.*;
import java.util.function.Consumer;

public class FormularioLivro extends FormularioBase {
    private JTextField txtAutor;
    private JTextField txtEditora;

    public FormularioLivro(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtAutor = new JTextField();
        txtEditora = new JTextField();

        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Editora:"));
        add(txtEditora);

        JButton btnAdicionar = new JButton("Adicionar Livro");
        btnAdicionar.addActionListener(e -> adicionarLivro());
        add(btnAdicionar);
    }

    private void adicionarLivro() {
        if (!validarCamposBasicos() || txtAutor.getText().trim().isEmpty() ||
                txtEditora.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico livro = criarItem();
            controle.adicionarItem(livro);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano deve ser um número!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditora.setText("");
        txtAno.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Livro(
                txtTitulo.getText().trim(),
                txtEditora.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtAutor.getText().trim()
        );
    }
}

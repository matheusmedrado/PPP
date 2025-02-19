import javax.swing.*;
import java.util.function.Consumer;

public class FormularioRevista extends FormularioBase {
    private JTextField txtOrganizador;
    private JTextField txtVolume;
    private JTextField txtNumero;
    private JTextField txtIssn;

    public FormularioRevista(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtOrganizador = new JTextField();
        txtVolume = new JTextField();
        txtNumero = new JTextField();
        txtIssn = new JTextField();

        add(new JLabel("Organizador:"));
        add(txtOrganizador);
        add(new JLabel("Volume:"));
        add(txtVolume);
        add(new JLabel("Número:"));
        add(txtNumero);
        add(new JLabel("ISSN:"));
        add(txtIssn);

        JButton btnAdicionar = new JButton("Adicionar Revista");
        btnAdicionar.addActionListener(e -> adicionarRevista());
        add(btnAdicionar);
    }

    private void adicionarRevista() {
        if (!validarCamposBasicos() || txtOrganizador.getText().trim().isEmpty() ||
                txtVolume.getText().trim().isEmpty() || txtNumero.getText().trim().isEmpty() ||
                txtIssn.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico revista = criarItem();
            controle.adicionarItem(revista);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano, volume e número devem ser números!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtOrganizador.setText("");
        txtVolume.setText("");
        txtNumero.setText("");
        txtIssn.setText("");
        txtAno.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Revista(
                txtTitulo.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtIssn.getText().trim(),
                Integer.parseInt(txtNumero.getText().trim()),
                txtOrganizador.getText().trim(),
                Integer.parseInt(txtVolume.getText().trim())
        );
    }
}
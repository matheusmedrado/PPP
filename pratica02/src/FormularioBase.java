import javax.swing.*;
import java.util.function.Consumer;
import java.awt.*;


public abstract class FormularioBase extends JPanel {
    protected JTextField txtTitulo;
    protected JTextField txtAno;
    protected ControleBiblioteca controle;
    protected Consumer<Void> onItemAdded;

    public FormularioBase(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        this.controle = controle;
        this.onItemAdded = onItemAdded;
        setLayout(new GridLayout(0, 2, 5, 5));
        criarCamposBasicos();
    }

    protected void criarCamposBasicos() {
        txtTitulo = new JTextField();
        txtAno = new JTextField();

        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Ano:"));
        add(txtAno);
    }

    protected boolean validarCamposBasicos() {
        return !txtTitulo.getText().trim().isEmpty() &&
                !txtAno.getText().trim().isEmpty();
    }

    protected abstract void limparCampos();
    protected abstract ItemBibliografico criarItem();
}

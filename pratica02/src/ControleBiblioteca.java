import java.util.ArrayList;
import java.util.List;

public class ControleBiblioteca {
    private List<ItemBibliografico> itens;

    public ControleBiblioteca() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemBibliografico item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public List<ItemBibliografico> listarItens() {
        return new ArrayList<>(itens);
    }
}
public class Livro extends ItemBibliografico implements Autoravel {
    private String autor;
    private String editora;

    public Livro(String titulo, String editora, int ano, String autor) {
        super(titulo, ano);
        this.editora = editora;
        this.autor = autor;
    }

    @Override
    public String getInfo() {
        return String.format("Livro: %s\nAutor: %s\nEditora: %s\nAno: %d",
                titulo, autor, editora, ano);
    }

    @Override
    public String getAutor() {
        return autor;
    }
}

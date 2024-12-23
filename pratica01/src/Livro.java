public class Livro extends Publicacao {
    private String autor;
    private String isbn;

    public Livro(String titulo, String editora, int ano, String autor, String isbn) {
        super(titulo, editora, ano);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String getInfo() {
        return "LIVRO:\n" + super.getInfo() +
                "\nAutor: " + autor +
                "\nISBN: " + isbn;
    }
}

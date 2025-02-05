public class Livro extends Publicacao {
    private String autor;

    public Livro(String titulo, String editora, int ano, String autor) {
        super(titulo, editora, ano);
        this.autor = autor;
    }

    @Override
    public String getInfo() {
        return "Livro: " + titulo + " " + autor + " Ano " + ano;
    }

    public String getAutor() {
        return autor;
    }
}

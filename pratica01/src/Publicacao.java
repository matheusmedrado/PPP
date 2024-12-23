public class Publicacao {
    protected String titulo;
    protected String editora;
    protected int ano;

    public Publicacao(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public String getInfo() {
        return "Título: " + titulo +
                "\nEditora: " + editora +
                "\nAno: " + ano;
    }
}

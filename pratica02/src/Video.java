public class Video extends ItemBibliografico implements Autoravel, Duravel {
    private String autor;
    private int duracao; // em minutos

    public Video(String titulo, int ano, String autor, int duracao) {
        super(titulo, ano);
        this.autor = autor;
        this.duracao = duracao;
    }

    @Override
    public String getInfo() {
        return String.format("Vídeo: %s\nAutor: %s\nDuração: %d min\nAno: %d",
                titulo, autor, duracao, ano);
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getDuracao() {
        return duracao;
    }
}
public abstract class ItemBibliografico {
    protected String titulo;
    protected int ano;

    public ItemBibliografico(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public abstract String getInfo();
    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
}
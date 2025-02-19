public class Revista extends ItemBibliografico {
    private String issn;
    private int numero;
    private String organizador;
    private int volume;

    public Revista(String titulo, int ano, String issn, int numero,
                   String organizador, int volume) {
        super(titulo, ano);
        this.issn = issn;
        this.numero = numero;
        this.organizador = organizador;
        this.volume = volume;
    }

    @Override
    public String getInfo() {
        return String.format("Revista: %s\nOrg.: %s\nVol.: %d\nNro.: %d\nAno: %d",
                titulo, organizador, volume, numero, ano);
    }

    public String getOrganizador() { return organizador; }
    public int getVolume() { return volume; }
    public int getNumero() { return numero; }
}
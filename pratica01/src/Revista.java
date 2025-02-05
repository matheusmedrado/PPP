public class Revista extends Publicacao {
    private String issn;
    private int numero;
    private String organizador;
    private int volume;

    public Revista(String titulo, String editora, int ano, String issn, int numero, String organizador, int volume) {
        super(titulo, editora, ano);
        this.issn = issn;
        this.numero = numero;
        this.organizador = organizador;
        this.volume = volume;
    }

    @Override
    public String getInfo() {
        return "Revista: " + titulo + " Org:" + organizador + " Vol:" + volume + 
               " Nro:" + numero + " Ano:" + ano;
    }

    public String getOrganizador() {
        return organizador;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumero() {
        return numero;
    }
}
public class Revista extends Publicacao {
    private String issn;
    private int numero;

    public Revista(String titulo, String editora, int ano, String issn, int numero) {
        super(titulo, editora, ano);
        this.issn = issn;
        this.numero = numero;
    }

    @Override
    public String getInfo() {
        return "REVISTA:\n" + super.getInfo() +
                "\nISSN: " + issn +
                "\nNúmero: " + numero;
    }
}
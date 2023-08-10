
public class Autor {

    private int autorID;
    private String nombreAutor;
    private String paisAutor;

    public Autor(int autorID, String nombreAutor, String paisAutor) {
        this.autorID = autorID;
        this.nombreAutor = nombreAutor;
        this.paisAutor = paisAutor;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPaisAutor() {
        return paisAutor;
    }

    public void setPaisAutor(String paisAutor) {
        this.paisAutor = paisAutor;
    }

}

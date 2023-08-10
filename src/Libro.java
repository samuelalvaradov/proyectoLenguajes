
public class Libro {

    private int libroID;
    private int autorID;
    private int categoriaID;
    private String titulo;
    private int año;

    public Libro(int libroID, int autorID, int categoriaID, String titulo, int año) {
        this.libroID = libroID;
        this.autorID = autorID;
        this.categoriaID = categoriaID;
        this.titulo = titulo;
        this.año = año;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}

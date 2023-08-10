
public class Categoria {

    private int categoriaID;
    private String nombreCat;

    public Categoria(int categoriaID, String nombreCat) {
        this.categoriaID = categoriaID;
        this.nombreCat = nombreCat;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

}


public class Editorial {

    private int editorialID;
    private int libroID;
    private String direccionEditorial;
    private String ciudadEditorial;
    private String paisEditorial;

    public Editorial(int editorialID, int libroID, String direccionEditorial, String ciudadEditorial, String paisEditorial) {
        this.editorialID = editorialID;
        this.libroID = libroID;
        this.direccionEditorial = direccionEditorial;
        this.ciudadEditorial = ciudadEditorial;
        this.paisEditorial = paisEditorial;
    }

    public int getEditorialID() {
        return editorialID;
    }

    public void setEditorialID(int editorialID) {
        this.editorialID = editorialID;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public String getDireccionEditorial() {
        return direccionEditorial;
    }

    public void setDireccionEditorial(String direccionEditorial) {
        this.direccionEditorial = direccionEditorial;
    }

    public String getCiudadEditorial() {
        return ciudadEditorial;
    }

    public void setCiudadEditorial(String ciudadEditorial) {
        this.ciudadEditorial = ciudadEditorial;
    }

    public String getPaisEditorial() {
        return paisEditorial;
    }

    public void setPaisEditorial(String paisEditorial) {
        this.paisEditorial = paisEditorial;
    }

}

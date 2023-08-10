
public class Usuario {

    private int usuarioID;
    private String nombreUsuario;
    private String direccionUsuario;
    private String identificacionUsuario;

    public Usuario(int usuarioID, String nombreUsuario, String direccionUsuario, String identificacionUsuario) {
        this.usuarioID = usuarioID;
        this.nombreUsuario = nombreUsuario;
        this.direccionUsuario = direccionUsuario;
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }
}

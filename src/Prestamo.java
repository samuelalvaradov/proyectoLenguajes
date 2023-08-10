
import java.util.Date;

public class Prestamo {

    private int prestamoID;
    private int usuarioID;
    private int libroID;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(int prestamoID, int usuarioID, int libroID, Date fechaPrestamo, Date fechaDevolucion) {
        this.prestamoID = prestamoID;
        this.usuarioID = usuarioID;
        this.libroID = libroID;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPrestamoID() {
        return prestamoID;
    }

    public void setPrestamoID(int prestamoID) {
        this.prestamoID = prestamoID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}

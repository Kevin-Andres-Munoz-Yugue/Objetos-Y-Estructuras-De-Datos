package mundo;

public abstract class Persona {

    private String numeroDocumento;
    private String nombre;
    private String correo;

    public Persona(String numeroDocumento, String nombre, String correo) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public abstract String getTipo();

    public abstract String resumen();
}
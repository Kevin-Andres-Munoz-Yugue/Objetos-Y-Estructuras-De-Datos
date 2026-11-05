package mundo;

public class Estudiante extends Persona {

    private String codigoEstudiante;
    private String programa;

    public Estudiante(String numeroDocumento, String nombre, String correo,
                      String codigoEstudiante, String programa) {

        super(numeroDocumento, nombre, correo);

        this.codigoEstudiante = codigoEstudiante;
        this.programa = programa;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }

    @Override
    public String resumen() {
        return "Estudiante: " + getNombre()
                + "\nDocumento: " + getNumeroDocumento()
                + "\nCódigo estudiante: " + codigoEstudiante
                + "\nCorreo: " + getCorreo()
                + "\nPrograma: " + programa;
    }
}
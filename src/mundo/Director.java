package mundo;

public class Director extends Directivo {

    private String programa;

    public Director(String numeroDocumento, String nombre, String correo,
                    String codigoEmpleado, String area,
                    String programa) {

        super(numeroDocumento, nombre, correo,
              codigoEmpleado, area, "Director");

        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String getTipo() {
        return "Director";
    }

    @Override
    public String resumen() {
        return "Director: " + getNombre()
                + "\nDocumento: " + getNumeroDocumento()
                + "\nCódigo empleado: " + getCodigoEmpleado()
                + "\nCorreo: " + getCorreo()
                + "\nÁrea: " + getArea()
                + "\nPrograma dirigido: " + programa;
    }
}
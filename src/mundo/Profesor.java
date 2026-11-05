package mundo;

public class Profesor extends Empleado {

    public Profesor(String numeroDocumento, String nombre, String correo,
                    String codigoEmpleado, String area) {

        super(numeroDocumento, nombre, correo, codigoEmpleado, area);
    }

    @Override
    public String getTipo() {
        return "Profesor";
    }

    @Override
    public String resumen() {
        return "Profesor: " + getNombre()
                + "\nDocumento: " + getNumeroDocumento()
                + "\nCódigo empleado: " + getCodigoEmpleado()
                + "\nCorreo: " + getCorreo()
                + "\nÁrea: " + getArea();
    }
}
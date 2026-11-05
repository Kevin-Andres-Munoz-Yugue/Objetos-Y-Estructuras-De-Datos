package mundo;

public class Directivo extends Empleado {

    private String cargo;

    public Directivo(String numeroDocumento, String nombre, String correo,
                     String codigoEmpleado, String area, String cargo) {

        super(numeroDocumento, nombre, correo, codigoEmpleado, area);

        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getTipo() {
        return "Directivo";
    }

    @Override
    public String resumen() {
        return "Directivo: " + getNombre()
                + "\nDocumento: " + getNumeroDocumento()
                + "\nCódigo empleado: " + getCodigoEmpleado()
                + "\nCorreo: " + getCorreo()
                + "\nÁrea: " + getArea()
                + "\nCargo: " + cargo;
    }
}
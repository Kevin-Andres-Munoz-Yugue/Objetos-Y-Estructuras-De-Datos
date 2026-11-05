package mundo;

public class Administrativo extends Empleado {

    private String cargo;

    public Administrativo(String numeroDocumento, String nombre, String correo,
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
        return "Administrativo";
    }

    @Override
    public String resumen() {
        return "Administrativo: " + getNombre()
                + "\nDocumento: " + getNumeroDocumento()
                + "\nCódigo empleado: " + getCodigoEmpleado()
                + "\nCorreo: " + getCorreo()
                + "\nÁrea: " + getArea()
                + "\nCargo: " + cargo;
    }
}
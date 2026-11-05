package mundo;

public abstract class Empleado extends Persona {

    private String codigoEmpleado;
    private String area;

    public Empleado(String numeroDocumento, String nombre, String correo,
                    String codigoEmpleado, String area) {

        super(numeroDocumento, nombre, correo);

        this.codigoEmpleado = codigoEmpleado;
        this.area = area;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
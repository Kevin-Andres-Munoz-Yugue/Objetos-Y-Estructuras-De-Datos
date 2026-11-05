package estructuras;

public class Cola<T> implements Contenedor<T> 
{
    private ListaDoble<T> elementos;

    public Cola() {
        elementos = new ListaDoble<>();
    }

    public void encolar(T dato) {
        elementos.agregar(dato);
    }

    public T desencolar() {
        if (elementos.estaVacia()) {
            return null;
        }

        return elementos.eliminarEnPosicion(0);
    }

    public T verPrimero() {
        if (elementos.estaVacia()) {
            return null;
        }

        return elementos.obtener(0);
    }

    @Override
    public boolean estaVacia() {
        return elementos.estaVacia();
    }

    @Override
    public int getTamanio() {
        return elementos.getTamanio();
    }

    @Override
    public void vaciar() {
        elementos.vaciar();
    }

    public ListaDoble<T> getElementos() {
        return elementos;
    }
}
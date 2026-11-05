package estructuras;

public class Pila<T> implements Contenedor<T> 
{
    private ListaDoble<T> elementos;

    public Pila() {
        elementos = new ListaDoble<>();
    }

    public void apilar(T dato) {
        elementos.agregarAlInicio(dato);
    }

    public T desapilar() {
        if (elementos.estaVacia()) {
            return null;
        }

        return elementos.eliminarEnPosicion(0);
    }

    public T verTope() {
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
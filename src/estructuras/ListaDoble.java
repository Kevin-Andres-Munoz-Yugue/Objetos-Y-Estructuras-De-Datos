package estructuras;

public class ListaDoble<T> implements Contenedor<T> 
{
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tamanio;

    public ListaDoble() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    public void agregar(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }

        tamanio++;
    }

    public void agregarAlInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }

        tamanio++;
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            return null;
        }

        NodoDoble<T> actual = primero;

        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    public void cambiar(int posicion, T dato) {
        if (posicion < 0 || posicion >= tamanio) {
            return;
        }

        NodoDoble<T> actual = primero;

        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(dato);
    }

    public int buscarPosicion(T dato) {
        NodoDoble<T> actual = primero;
        int posicion = 0;

        while (actual != null) {

            if (actual.getDato().equals(dato)) {
                return posicion;
            }

            actual = actual.getSiguiente();
            posicion++;
        }

        return -1;
    }

    public boolean eliminar(T dato) {
        NodoDoble<T> actual = primero;

        while (actual != null) {

            if (actual.getDato().equals(dato)) {
                eliminar(actual);
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public T eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            return null;
        }

        NodoDoble<T> actual = primero;

        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        eliminar(actual);

        return actual.getDato();
    }

    private void eliminar(NodoDoble<T> nodo) {

        if (nodo.getAnterior() == null) {
            primero = nodo.getSiguiente();
        } else {
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        }

        if (nodo.getSiguiente() == null) {
            ultimo = nodo.getAnterior();
        } else {
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
        }

        tamanio--;
    }

    public boolean contiene(T dato) {
        return buscarPosicion(dato) != -1;
    }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    @Override
    public boolean estaVacia() {
        return tamanio == 0;
    }

    @Override
    public int getTamanio() {
        return tamanio;
    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

    public String recorrerAdelante() {
        String texto = "";
        NodoDoble<T> actual = primero;

        while (actual != null) {
            texto = texto + actual.getDato().toString();

            if (actual.getSiguiente() != null) {
                texto = texto + ", ";
            }

            actual = actual.getSiguiente();
        }

        return texto;
    }

    public String recorrerAtras() {
        String texto = "";
        NodoDoble<T> actual = ultimo;

        while (actual != null) {
            texto = texto + actual.getDato().toString();

            if (actual.getAnterior() != null) {
                texto = texto + ", ";
            }

            actual = actual.getAnterior();
        }

        return texto;
    }
}
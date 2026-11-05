package estructuras;

public interface Contenedor<T> 
{
    boolean estaVacia();

    int getTamanio();

    void vaciar();
}
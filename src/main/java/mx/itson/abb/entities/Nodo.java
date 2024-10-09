
package mx.itson.abb.entities;

public class Nodo {
    
    private int dato;
    private Nodo ligaIzquierda;
    private Nodo ligaDerecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.ligaIzquierda = null;
        this.ligaDerecha = null;
    }

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param Nodo the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the ligaIzquierda
     */
    public Nodo getLigaIzquierda() {
        return ligaIzquierda;
    }

    /**
     * @param ligaIzquierda the ligaIzquierda to set
     */
    public void setLigaIzquierda(Nodo ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }

    /**
     * @return the ligaDerecha
     */
    public Nodo getLigaDerecha() {
        return ligaDerecha;
    }

    /**
     * @param ligaDerecha the ligaDerecha to set
     */
    public void setLigaDerecha(Nodo ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }
}

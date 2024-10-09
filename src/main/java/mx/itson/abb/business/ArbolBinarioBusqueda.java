
package mx.itson.abb.business;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import mx.itson.abb.entities.Nodo;
import mx.itson.abb.ui.ArbolGrafico;

public class ArbolBinarioBusqueda {

    private Nodo raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void crearRaiz(int dato) {
        raiz = new Nodo(dato);
    }

    public void insertarNodo(int dato) {

        Nodo nodoActual = obtenerRaiz();

        while (true) {
            if (dato == nodoActual.getDato()) {
                System.out.println("Ya existe el Nodo con el valor de " + dato);
                break;
            } else if (dato < nodoActual.getDato()) {
                if (nodoActual.getLigaIzquierda() == null) {
                    nodoActual.setLigaIzquierda(new Nodo(dato));
                    break;
                } else {
                    nodoActual = nodoActual.getLigaIzquierda();
                }
            } else if (dato > nodoActual.getDato()) {
                if (nodoActual.getLigaDerecha() == null) {
                    nodoActual.setLigaDerecha(new Nodo(dato));
                    break;
                } else {
                    nodoActual = nodoActual.getLigaDerecha();
                }
            }
        }
    }

    public Nodo eliminarPorPredecesor(int dato, Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        if (dato < nodo.getDato()) {
            nodo.setLigaIzquierda(eliminarPorPredecesor(dato, nodo.getLigaIzquierda()));
        } else if (dato > nodo.getDato()) {
            nodo.setLigaDerecha(eliminarPorPredecesor(dato, nodo.getLigaDerecha()));
        } else {
            if (nodo.getLigaIzquierda() == null) {
                return nodo.getLigaDerecha();
            } else if (nodo.getLigaDerecha() == null) {
                return nodo.getLigaIzquierda();
            } else {
                Nodo predecesor = buscarNodoMayor(nodo.getLigaIzquierda());
                nodo.setDato(predecesor.getDato());
                nodo.setLigaIzquierda(eliminarPorPredecesor(predecesor.getDato(), nodo.getLigaIzquierda()));
            }
        }

        return nodo;
    }

    public Nodo eliminarPorSucesor(int dato, Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        if (dato < nodo.getDato()) {
            nodo.setLigaIzquierda(eliminarPorSucesor(dato, nodo.getLigaIzquierda()));
        } else if (dato > nodo.getDato()) {
            nodo.setLigaDerecha(eliminarPorSucesor(dato, nodo.getLigaDerecha()));
        } else {
            if (nodo.getLigaIzquierda() == null) {
                return nodo.getLigaDerecha();
            } else if (nodo.getLigaDerecha() == null) {
                return nodo.getLigaIzquierda();
            } else {
                Nodo sucesor = buscarNodoMenor(nodo.getLigaDerecha());
                nodo.setDato(sucesor.getDato());
                nodo.setLigaDerecha(eliminarPorSucesor(sucesor.getDato(), nodo.getLigaDerecha()));
            }
        }

        return nodo;
    }

    public boolean existeNodo(int dato, Nodo nodo) {
        if (nodo == null) {
            return false;
        }

        if (dato == nodo.getDato()) {
            return true;
        } else if (dato < nodo.getDato()) {
            return existeNodo(dato, nodo.getLigaIzquierda());
        } else { 
            return existeNodo(dato, nodo.getLigaDerecha());
        }
    }

    public Nodo buscarNodoMenor(Nodo nodo) {
        if (nodo.getLigaIzquierda() == null) {
            return nodo;
        } else {
            return buscarNodoMenor(nodo.getLigaIzquierda());
        }
    }

    public Nodo buscarNodoMayor(Nodo nodo) {
        if (nodo.getLigaDerecha() == null) {
            return nodo;
        } else {
            return buscarNodoMayor(nodo.getLigaDerecha());
        }
    }

    public void recorrerPreOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        System.out.print(nodo.getDato() + " || ");
        recorrerPreOrden(nodo.getLigaIzquierda());
        recorrerPreOrden(nodo.getLigaDerecha());
    }

    public void recorrerInOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        recorrerInOrden(nodo.getLigaIzquierda());
        System.out.print(nodo.getDato() + " || ");
        recorrerInOrden(nodo.getLigaDerecha());
    }

    public void recorrerPostOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        recorrerPostOrden(nodo.getLigaIzquierda());
        recorrerPostOrden(nodo.getLigaDerecha());
        System.out.print(nodo.getDato() + " || ");
    }

    public void recorrerNiveles() {
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(obtenerRaiz());

        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            System.out.print(nodo.getDato() + " || ");

            if (nodo.getLigaIzquierda() != null) {
                cola.add(nodo.getLigaIzquierda());
            }
            if (nodo.getLigaDerecha() != null) {
                cola.add(nodo.getLigaDerecha());
            }
        }
    }

    public static void mostrarArbol(ArbolBinarioBusqueda abb) {
        if (abb.existeArbol()) {
            JFrame ventana = new JFrame("Árbol Binario de Búsqueda");
            ArbolGrafico panel = new ArbolGrafico(abb.obtenerRaiz());

            ventana.add(panel);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            ventana.setVisible(true);
        } else {
            System.out.println("\nEl Árbol no existe\n");
        }
    }
    

    public Nodo obtenerRaiz() {
        return raiz;
    }
    
    public int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + Math.max(obtenerAltura(nodo.getLigaIzquierda()), obtenerAltura(nodo.getLigaDerecha()));
    }

    public int obtenerHojas(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.getLigaIzquierda() == null && nodo.getLigaDerecha() == null) {
            return 1;
        } else {
            return obtenerHojas(nodo.getLigaIzquierda()) + obtenerHojas(nodo.getLigaDerecha());
        }
    }

    public int obtenerNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + obtenerNodos(nodo.getLigaIzquierda()) + obtenerNodos(nodo.getLigaDerecha());
    }

    public boolean esArbolCompleto(Nodo nodo, int indice, int totalNodos) {
        if (nodo == null) {
            return true;
        }

        if (indice >= totalNodos) {
            return false;
        }

        return esArbolCompleto(nodo.getLigaIzquierda(), 2*indice+1, totalNodos) &&
                esArbolCompleto(nodo, 2*indice+2, totalNodos);
    }

    public boolean esArbolLleno(Nodo nodo) {
        if (nodo == null) {
            return true;
        }

        if (nodo.getLigaIzquierda() == null && nodo.getLigaDerecha() == null) {
            return true;
        }

        if (nodo.getLigaIzquierda() == null || nodo.getLigaDerecha() == null) {
            return false;
        }

        return esArbolLleno(nodo.getLigaIzquierda()) && esArbolLleno(nodo.getLigaDerecha());
    }

    public void eliminarArbol() {
        raiz = null;
    }

    public boolean existeArbol() {
        return raiz != null;
    }

    

    public static void menu() {
        System.out.println("\n          Menú");
        System.out.println("1) Crear Raíz");
        System.out.println("2) Insertar Elemento");
        System.out.println("3) Eliminar Nodo (PREDECESOR)");
        System.out.println("4) Eliminar Nodo (SUCESOR)");
        System.out.println("5) Buscar Elemento");
        System.out.println("6) Buscar Nodo Menor");
        System.out.println("7) Buscar Nodo Mayor");
        System.out.println("8) Recorrer en PreOrden");
        System.out.println("9) Recorrer en InOrden");
        System.out.println("10) Recorrer en PostOrden");
        System.out.println("11) Recorrer por Niveles");
        System.out.println("12) Graficar Árbol");
        System.out.println("13) Obtener Raíz");
        System.out.println("14) Obtener Altura");
        System.out.println("15) Obtener Cantidad de Hojas");
        System.out.println("16) Obtener Cantidad de Nodos");
        System.out.println("17) ¿Es un Árbol Binario Completo?");
        System.out.println("18) ¿Es un Árbol Binario Lleno");
        System.out.println("19) Eliminar Árbol");
        System.out.println("20) Finalizar Programa");
    }

    public int validarEntradaOperacion(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        Pattern cadena = Pattern.compile("^([1-9]|1[0-9]|20)$");

        while (true) {
            System.out.print(mensaje);
            String valor = entrada.nextLine().trim();

            try {
                if (valor.isEmpty()) {
                    throw new IllegalArgumentException("El campo no puede estar vacío");
                } else if (!cadena.matcher(valor).matches()) {
                    throw new IllegalArgumentException("Opción inválida");
                }
            
                return Integer.parseInt(valor); 
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: " + e.getMessage() + "\n");
            }
        }
    }

    public int validarEntradaDato(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        Pattern cadena = Pattern.compile("^-?[0-9]+$");

        while (true) {
            System.out.print(mensaje);
            String valor = entrada.nextLine().trim();

            try {
                if (valor.isEmpty()) {
                    throw new IllegalArgumentException("El campo no puede estar vacío");
                } else if (!cadena.matcher(valor).matches()) {
                    throw new IllegalArgumentException("Solo se aceptan valores numéricos");
                }
            
                return Integer.parseInt(valor); 
            } catch (IllegalArgumentException e) {
                System.out.println("\nError: " + e.getMessage() + "\n");
            }
        }

    }
    
}

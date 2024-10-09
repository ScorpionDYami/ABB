
package mx.itson.abb.ui;

import mx.itson.abb.business.ArbolBinarioBusqueda;
import static mx.itson.abb.business.ArbolBinarioBusqueda.*;

public class Arbol {

    public static void main(String[] args) {

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        int opc;

        do {
            menu();
            opc = abb.validarEntradaOperacion("\nIngresar opción: ");
            switch (opc) {
                case 1: //Crear Raíz
                    if (!abb.existeArbol()) {
                        abb.crearRaiz(abb.validarEntradaDato("Ingresar Raíz: "));
                    } else {
                        System.out.println("\nLa raíz ya existe\n");
                    }
                    break;
                case 2: //Insertar Elemento
                    if (abb.existeArbol()) {
                        abb.insertarNodo(abb.validarEntradaDato("Ingresar elemento: "));
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 3: //Eliminar Por Predecesor
                    if (abb.existeArbol()) {
                        int valor = abb.validarEntradaDato("Ingresar elemento a eliminar: ");
                        if (abb.existeNodo(valor, abb.obtenerRaiz())) {
                            System.out.println("El elemento " + valor + " fue eliminado con exito y fue reemplazado por el Nodo con valor " + abb.eliminarPorPredecesor(valor, abb.obtenerRaiz()).getDato());
                        } else {
                            System.out.println("\nEl elemento " + valor + " no existe en el árbol\n");
                        }
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 4: //Eliminar Por Sucesor
                    if (abb.existeArbol()) {
                        int valor = abb.validarEntradaDato("Ingresar elemento a eliminar: ");
                        if (abb.existeNodo(valor, abb.obtenerRaiz())) {
                            System.out.println("El elemento " + valor + " fue eliminado con exito y fue reemplazado por el Nodo con valor " + abb.eliminarPorSucesor(valor, abb.obtenerRaiz()).getDato());
                        } else {
                            System.out.println("\nEl elemento " + valor + " no existe en el árbol\n");
                        }
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 5: //Buscar Elemento
                    if (abb.existeArbol()) {
                        int valor = abb.validarEntradaDato("Ingresar elemento a buscar: ");
                        if (abb.existeNodo(valor, abb.obtenerRaiz())) {
                            System.out.println("\nEl elemento " + valor + " si existe en el árbol\n");
                        } else {
                            System.out.println("\nEl elemento " + valor + " no existe en el árbol\n");
                        }
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 6: //Buscar Nodo Menor
                    if (abb.existeArbol()) {
                        System.out.println("El Nodo menor contiene al elemento " + abb.buscarNodoMenor(abb.obtenerRaiz()).getDato());
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 7: //Buscar Nodo Mayor
                    if (abb.existeArbol()) {
                        System.out.println("El Nodo mayor contiene al elemento " + abb.buscarNodoMayor(abb.obtenerRaiz()).getDato());
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 8: //Recorrer PreOrden
                    if (abb.existeArbol()) {
                        abb.recorrerPreOrden(abb.obtenerRaiz());
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 9: //Recorrer InOrden
                    if (abb.existeArbol()) {
                        abb.recorrerInOrden(abb.obtenerRaiz());
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 10:    //Recorrer PostOrden        
                    if (abb.existeArbol()) {
                        abb.recorrerPostOrden(abb.obtenerRaiz());
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 11:    //Recorrer por Niveles (Amplitud)
                    if (abb.existeArbol()) {
                        abb.recorrerNiveles();
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 12:    //Graficar Árbol
                    mostrarArbol(abb);
                    break;
                case 13:    //Obtener Raíz
                    if (abb.existeArbol()) {
                        System.out.println("Raíz: " + abb.obtenerRaiz().getDato()); 
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 14:    //Obtener Altura
                    int altura = abb.obtenerAltura(abb.obtenerRaiz());
                    System.out.println("Altura: " + altura);
                    break;
                case 15:    //Obtener Total de Hojas
                    int hojas = abb.obtenerHojas(abb.obtenerRaiz());
                    System.out.println("Cantidad de Hojas: " + hojas);
                    break;
                case 16:    //Obtener Total de Nodos
                    int nodos = abb.obtenerNodos(abb.obtenerRaiz());
                    System.out.println("Cantidad de Nodos: " + nodos);
                    break;
                case 17:    //¿Árbol Completo?
                    if (abb.esArbolCompleto(abb.obtenerRaiz(), 0, abb.obtenerNodos(abb.obtenerRaiz()))) {
                        System.out.println("\nSi es un Árbol Completo\n");    
                    } else {
                        System.out.println("\nNo es un Árbol Completo\n");
                    }
                    break;
                case 18:    //¿Árbol Lleno?
                    if (abb.esArbolLleno(abb.obtenerRaiz())) {
                        System.out.println("\nSi es un Árbol Lleno\n");
                    } else {
                        System.out.println("\nNo es un Árbol Lleno\n");
                    }
                    break;
                case 19:    //Eliminar Árbol
                    if (abb.existeArbol()) {
                        abb.eliminarArbol();
                        System.out.println("\nEl Árbol fue eliminado con exito\n");
                    } else {
                        System.out.println("\nEl Árbol no existe\n");
                    }
                    break;
                case 20:
                    System.out.println("\nPrograma Finalizado");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }
}


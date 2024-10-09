package mx.itson.abb.ui;

import javax.swing.*;
import java.awt.*;
import mx.itson.abb.entities.Nodo;

public class ArbolGrafico extends JPanel {
    private Nodo raiz;

    public ArbolGrafico(Nodo raiz) {
        this.raiz = raiz;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarArbol(g, raiz, getWidth() / 2, 40, 100);
    }

    private void dibujarArbol(Graphics g, Nodo nodo, int x, int y, int espacio) {
        if (nodo != null) {
            // Color de fondo del círculo
            g.setColor(Color.LIGHT_GRAY); 
            g.fillOval(x - 20, y - 20, 40, 40); // Dibuja el círculo
            
            // Color del texto
            g.setColor(Color.BLACK);
            FontMetrics metrics = g.getFontMetrics(); // Para centrar el texto
            int textWidth = metrics.stringWidth(String.valueOf(nodo.getDato()));
            int textHeight = metrics.getHeight();
            g.drawString(String.valueOf(nodo.getDato()), x - textWidth / 2, y + textHeight / 4); // Dibuja el texto centrado
            
            // Dibujar líneas hacia los nodos hijos
            if (nodo.getLigaIzquierda() != null) {
                g.setColor(Color.BLUE); // Color de la línea izquierda
                g.drawLine(x, y + 20, x - espacio, y + 50 - 20); // Línea hacia la izquierda
                dibujarArbol(g, nodo.getLigaIzquierda(), x - espacio, y + 50, espacio / 2);
            }
            if (nodo.getLigaDerecha() != null) {
                g.setColor(Color.RED); // Color de la línea derecha
                g.drawLine(x, y + 20, x + espacio, y + 50 - 20); // Línea hacia la derecha
                dibujarArbol(g, nodo.getLigaDerecha(), x + espacio, y + 50, espacio / 2);
            }
        }
    }
}

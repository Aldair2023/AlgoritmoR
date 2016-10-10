/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aldair
 */
public class Helper {

    public static int mensaje(Component ventana, String info, String titulo, int tipo) {
        int retorno = -1;
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                retorno = JOptionPane.showConfirmDialog(ventana, info, titulo, JOptionPane.YES_NO_OPTION);
                break;
        }
        return retorno;
    }

    public static String recibirDatos(Component ventana, String info) {
        String aux;
        aux = JOptionPane.showInputDialog(ventana, info);
        return aux;

    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }

    public static void limpiarTabla(JTable tabla) {
        int nFilas, nColumnas;
        nFilas = tabla.getRowCount();
        nColumnas = tabla.getColumnCount();

        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {

                tabla.setValueAt("", i, j);
            }
        }
    }

    public static void tablaPorDefecto(JTable tabla) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);

    }

    public static int[][] PasarDatos(JTable tabla) {
        int nFilas, nColumnas;

        nFilas = tabla.getRowCount();
        nColumnas = tabla.getColumnCount();

        int m[][] = new int[nFilas][nColumnas];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                m[i][j] = (int) tabla.getValueAt(i, j);
            }

        }
        return m;
    }

    public static String recorridoHaciaDerecha(int[][] m, int i, int in, int fin) {
        String aux = "";
        for (int j = in; j <= fin; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaAbajo(int[][] m, int j, int in, int fin) {
        String aux = "";
        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {
        String aux = "";
        for (int j = in; j >= fin; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }
    public static String recorridoHaciaArriba(int[][] m, int j, int in, int fin) {
      
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }
    
     public static String recorridoDiagonalSecundariaAbajo(int[][] m, int in, int fin) {
      
        int nc =m[0].length;
        String aux = "";
        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][nc-1-i]+ ", ";
            
        }
        return aux;

    }
     public static String recorridoDiagonalPrincipalAbajo(int[][] m, int in, int fin) {
      
        String aux = "";
        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][i]+ ", ";
            
        }
        return aux;

    }
     public static String recorridoDiagonalSecundariaArriba(int[][] m, int in, int fin) {
        
        int nc =m[0].length;
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][nc-1-i]+ ", ";
            
        }
        return aux;

    }
    
    public static String recorridoUno(JTable tabla) {
        int m[][] = PasarDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf-1, 0);
        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 1, nc/2);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc/2, 1, nf-1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf-1, (nc/2+1), nc-1);
        aux = aux + Helper.recorridoHaciaArriba(m, nc-1, nf-2, 0);
        

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }
    
    public static String recorridoDos(JTable tabla) {
        int m[][] = PasarDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 0, nc - 1);
        aux = aux + Helper.recorridoHaciaAbajo(m, nf-1,1, nf/2);
        aux = aux + Helper.recorridoHaciaIzquierda(m, nf/2, nc-2, 0);
        aux = aux + Helper.recorridoHaciaAbajo(m, 0, (nf/2+1), nf-1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf-1, 1, nc-1);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
        
    }
    public static String recorridoTres(JTable tabla) {
        int m[][] = PasarDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaDerecha(m, nf/2, nc/2, (nc/2+1));
        aux = aux + Helper.recorridoHaciaAbajo(m, (nc/2+1), nf/2+1, nf/2+1);
        aux = aux + Helper.recorridoHaciaIzquierda(m, (nf/2+1), nc/2, (nc/2-1));
        aux = aux + Helper.recorridoHaciaArriba(m, nc/2-1, nf/2, nf/2-1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf/2-1, nc/2, nc-1);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc-1, nf/2, nf-1);
        aux = aux + Helper.recorridoHaciaIzquierda(m, nf-1, nc/2+1, 0);
        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf/2+1, 0);
        aux = aux + Helper.recorridoHaciaDerecha(m, 0, nc/2-1, nc-1);
        

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }
    
    public static String recorridoCuatro(JTable tabla) {
        int m[][] = PasarDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 0, nc-1);
        aux = aux + Helper.recorridoDiagonalSecundariaAbajo(m, 1, nf-1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf-1, 1 , nc-1);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }
    
    public static String recorridoCinco(JTable tabla) {
        int m[][] = PasarDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf-1, 1);
        aux = aux + Helper.recorridoDiagonalPrincipalAbajo(m, 0, nc/2);
        aux = aux + Helper.recorridoDiagonalSecundariaArriba(m, nf/2-1, 0);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc-1, 1, nf-1);
        

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }
    
}

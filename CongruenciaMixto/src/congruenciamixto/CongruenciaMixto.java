/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruenciamixto;

import javax.swing.JOptionPane;

/**
 *
 * @author lenovo-user
 */
public class CongruenciaMixto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 0;  
        int c; 
        int x = 0;
        int m;
        boolean dato = true;
        do {

            a = multiplicador();
            c = constante_aditiva();
            x = semilla();
            m = modulo();
            calcular(x, a, c, m);

        } while (dato);
    }

    // Aqui se ingresa el valor de la semilla y se verifica si el número es entero
    public static int semilla() {
        int x = 0;
        boolean entero = false;
        do {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de  X:", null, JOptionPane.INFORMATION_MESSAGE));
                entero = true;
                if (x == JOptionPane.CANCEL_OPTION) {
                    entero = false;
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return x;
    }

    //Aqui se ingresa el valor de el multiplicador para ello se debe validar que debe ser un número entero impar
    public static int multiplicador() {
        int a = 0;
        boolean entero = false;
        do {
            try {
                a = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de a", null, JOptionPane.INFORMATION_MESSAGE));
                //Aqui se condiciona con respecto al documento que debe ser mayor a cero y su mod debe ser igual a 1
                if (a > 0 && a % 2 == 1) {
                    return a;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se un número entero impar");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero un número entero impar");
            }
        } while (!entero);
        return a;
    }

    public static int constante_aditiva() {
        int c = 0;
        boolean numeroentero = false;
        do {
            try {
                //Se ingresa el valor de la constante aditiva
                c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de c:", null, JOptionPane.INFORMATION_MESSAGE));
                //Aqui se verifica si el número es un número primo
                if (c % 2 == 1) {
                    int a = 0;
                    for (int i = 1; i < (c + 1); i++) {
                        if (c % i == 0) {
                            a++;
                        }
                    }
                    //Se condiciona que el valor sea in número entero impar
                    if (a != 2) {
                        JOptionPane.showMessageDialog(null, "Debe ser un número primo");
                    } else {
                        numeroentero = true;
                    }                

                } else {
                    //condicionamos si el número es entero e impar
                    JOptionPane.showMessageDialog(null, "Debe se entero impar");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero impar");
            }
        } while (!numeroentero);
        return c;
    }

    //Aqui se ingresa el valor del módulo
    public static int modulo() {
        int m = 0;
        boolean numeroentero = false;
        do {
            try {
                m = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de m", null, JOptionPane.INFORMATION_MESSAGE));
                //Se condiciona que m debe ser mayor a  cero y asi mismo debe ser entero
                if (m > 0) {
                    return m;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se entero");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!numeroentero);
        return m;
    }

    //Aqui se realiza el contador donde verificaremos los datos
    public static void calcular(int x, int a, int c, int m) {
        int r = 0; // Resultado
        int i = 0; // Contador
        int x2 = x;
        double aux1, aux2;
        System.out.println("n\tX\t(ax + c)/m\tXn\tNumeros Uniformes");
        while (r != x2) {
            //Aplicamos la formula obtenida
            r = (a * x + c) % m;
            //tomamos este valor para separar los valores
            aux1 = (a * x + c) / m;
            //obtenemos los datos decimales
            aux2 = r % m;
            System.out.println(i + "\t" + x + "\t" + (int) aux1 + "+" + (int) aux2 + "/" + (int) m + "\t\t" + (int) r + "\t" + (double) r / m);
            x = (int) r;
            i++;
        }
    }

}

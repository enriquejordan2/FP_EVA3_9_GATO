/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_9_gato;

import java.util.Scanner;



/**
 *
 * @author Jose Enrique
 */
public class EVA3_9_GATO {

    /**
     * @param args the command line arguments
     */
    public static char[][] tablero = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    public static char turno = 'X';
    public static boolean ganador = false;

    public static void main(String[] args) {
        Scanner captu = new Scanner(System.in);

        // Mostrar el tablero inicial
        while (!ganador) {
            tableroJuego();
            System.out.println("Turno del jugador " + turno + ":");
            int celda = captu.nextInt();
            if (celda < 1 || celda > 9) {
                System.out.println("Numero invalido Debes escoger un numero entre 1 y 9: ");
                continue;
            }
            if (!colocarFicha(celda)) {
                System.out.println("La celda ya esta ocupada escoge otra celda:");
                continue;
            }

            // Verificar si alguien ha ganado
            ganador = ganadorJuego();
            if (ganador) {
                tableroJuego();
                System.out.println("Felicidades jugador  " + turno + "ganaste");
            } else {
                // Cambiar el turno
                turno = (turno == 'X') ? 'O' : 'X';
            }

            // Verificar si el tablero está lleno (empate)
            if (tableroLlena()) {
                tableroJuego();
                System.out.println("Empate el tablero esta lleno");
                break;
            }
        }

        
    }

    public static void tableroJuego() {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            if (i < 2) System.out.println("_______________");
        }
    }

    public static boolean colocarFicha(int celda) {
        int fila = (celda - 1) / 3;
        int columna = (celda - 1) % 3;

        // Colocar la ficha solo si la celda está vacía
        if (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
            return false;
        } else {
            tablero[fila][columna] = turno;
            return true;
        }
    }

    public static boolean ganadorJuego() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            // Verificar fila
            if (tablero[i][0] == turno && tablero[i][1] == turno && tablero[i][2] == turno) {
                return true;
            }
            // Verificar columna
            if (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) {
            return true;
        }
        if (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno) {
            return true;
        }

        return false;
    }

    public static boolean tableroLlena() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != 'X' && tablero[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
   
    
}
}

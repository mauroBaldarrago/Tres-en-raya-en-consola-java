// Laboratorio N°21 - Ejercicio 6
// Autor: Mauro Daniel Baldarrago Flores
// Tiempo 1h y 30min
import java.util.Scanner;
public class TresEnRayaDoble {

    public static void main(String[] args) {
        String miLetra;
        String[][] tablero = new String[3][3];
        int contador = 1;

        inicializarTablero(tablero);
        miLetra = ingreseLetra();

        mostrarTablero(tablero);

        while (contador <= 9) {
            System.out.println("\nIngrese jugada 1-9:");
            int jugada = ingreseJugada();

            int fila = 2 - (jugada - 1) / 3;
            int columna = (jugada - 1) % 3;

            if (!tablero[fila][columna].equals("")) {
                System.out.println("Esa casilla ya está ocupada. Intente otra.");
                continue;
            }

            tablero[fila][columna] = miLetra;
            mostrarTablero(tablero);

            if (esJugadaGanadora(tablero, miLetra)) {
                System.out.println("¡GANA " + miLetra + "!");
                return;
            }

            miLetra = (miLetra.equals("X")) ? "O" : "X";
            contador++;
        }

        System.out.println("¡EMPATE!");
        System.out.println("¡TERMINAMOS!");
    }
    public static void inicializarTablero(String[][] tablero) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = "";
    }
    public static String ingreseLetra() {
        Scanner sc = new Scanner(System.in);
        String letra;
        System.out.println("Ingrese su letra X o 0:");
        letra = sc.next().toUpperCase();

        while (!letra.equals("X") && !letra.equals("O")) {
            System.out.println("Inválido");
            System.out.println("Ingrese su letra X o 0:");
            letra = sc.next().toUpperCase();
        }
        return letra;
    }
    public static int ingreseJugada() {
        Scanner sc = new Scanner(System.in);
        int jugada = sc.nextInt();

        while (jugada < 1 || jugada > 9) {
            System.out.println("Error");
            System.out.println("Ingrese jugada 1-9:");
            jugada = sc.nextInt();
        }
        return jugada;
    }
    public static void mostrarTablero(String[][] elTablero) {
        for (int i = 0; i < 3; i++) {
            System.out.print("\t");
            for (int j = 0; j < 3; j++) {
                String valor = elTablero[i][j];
                System.out.print(valor.equals("") ? " " : valor);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  _______________");
            }
        }
    }
    public static boolean esJugadaGanadora(String[][] t, String l) {
        boolean gano = false;
        for (int i = 0; i < 3; i++) {
            if (t[i][0].equals(l) && t[i][1].equals(l) && t[i][2].equals(l)) gano = true;
            if (t[0][i].equals(l) && t[1][i].equals(l) && t[2][i].equals(l)) gano = true;
        }
        if (t[0][0].equals(l) && t[1][1].equals(l) && t[2][2].equals(l)) gano = true;
        if (t[0][2].equals(l) && t[1][1].equals(l) && t[2][0].equals(l)) gano = true;
        return gano;
    }
}


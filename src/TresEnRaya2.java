// Laboratorio N°21 - Ejercicio2
// Autor: Mauro Daniel Baldarrago Flores
// Tiempo 1h y 30min
import java.util.Scanner;
public class TresEnRaya2 {
    public static void main(String[] args) {
        String miLetra, computadoraLetra, turno;
        int jugada;
        String[] tablero = {"", "", "", "", "", "", "", "", "", ""};
        miLetra = ingreseLetra();
        if (miLetra.equals("X")) {
            computadoraLetra = "O";
        } else {
            computadoraLetra = "X";
        }
        turno = "X";
        int contador = 1;

        mostrarTablero(tablero);
        while (contador <= 9) {
            if (turno.equals(miLetra)) {
                jugada = ingreseJugada();
                while (!tablero[jugada].equals("")) {
                    jugada = ingreseJugada();
                }
            } else {
                jugada = jugarComputadora(tablero, computadoraLetra, miLetra);
                System.out.println("\nLa computadora juega en: " + jugada);
            }
            tablero[jugada] = turno;
            System.out.println();
            mostrarTablero(tablero);

            if (esJugadaGanadora(tablero, turno)) {
                System.out.println("GANO " + turno);
                break;
            }
            turno = turno.equals("X") ? "O" : "X";
            contador++;
        }
        if (contador > 9) {
            System.out.println("EMPATE");
        }
        System.out.println("TERMINAMOS!!!!");
    }

    public static String ingreseLetra() {
        String miLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su letra X o 0:");
        miLetra = sc.next();
        miLetra = miLetra.toUpperCase();

        while (!(miLetra.equals("X") || miLetra.equals("O"))) {
            System.out.println("\nInválido");
            System.out.println("Ingrese su letra X o 0:");
            miLetra = sc.next();
            miLetra = miLetra.toUpperCase();
        }
        return miLetra;
    }

    public static void mostrarTablero(String[] elTablero) {

        System.out.println("\t" + elTablero[7] + "  |  " + elTablero[8] + "  |  " + elTablero[9]);
        System.out.println("  _______________");
        System.out.println("\t" + elTablero[4] + "  |  " + elTablero[5] + "  |  " + elTablero[6]);
        System.out.println("  _______________");
        System.out.println("\t" + elTablero[1] + "  |  " + elTablero[2] + "  |  " + elTablero[3]);
    }

    public static int ingreseJugada() {

        int jugada;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese jugada 1-9");
        jugada = sc.nextInt();

        while (jugada > 9 || jugada < 1) {
            System.out.println("\nError");
            System.out.println("Ingrese jugada:");
            jugada = sc.nextInt();
        }
        return jugada;
    }

    public static int jugarComputadora(String[] tablero, String computadoraLetra, String miLetra) {
        for (int i = 1; i <= 9; i++) {
            if (tablero[i].equals("")) {
                tablero[i] = computadoraLetra;
                if (esJugadaGanadora(tablero, computadoraLetra)) {
                    tablero[i] = "";
                    return i;
                }
                tablero[i] = "";
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (tablero[i].equals("")) {
                tablero[i] = miLetra;
                if (esJugadaGanadora(tablero, miLetra)) {
                    tablero[i] = "";
                    return i;
                }
                tablero[i] = "";
            }
        }
        if (tablero[5].equals("")) {
            return 5;
        }
        int[] corners = {1, 3, 7, 9};
        for (int i : corners) {
            if (tablero[i].equals("")) {
                return i;
            }
        }
        int[] lados = {2, 4, 6, 8};
        for (int i : lados) {
            if (tablero[i].equals("")) {
                return i;
            }
        }
        return 1;
    }

    public static boolean esJugadaGanadora( String [] elTablero, String laLetra){

        boolean gano = false;
        gano  =  ( elTablero[1].equals(laLetra) && elTablero[2].equals(laLetra) &&
                elTablero[3].equals(laLetra) ) ||
                ( elTablero[4].equals(laLetra) &&
                        elTablero[5].equals(laLetra) &&  elTablero[6].equals(laLetra) ) ||
                ( elTablero[7].equals(laLetra) &&
                        elTablero[8].equals(laLetra) &&  elTablero[9].equals(laLetra) ) ||
                ( elTablero[1].equals(laLetra) &&
                        elTablero[4].equals(laLetra) &&  elTablero[7].equals(laLetra) ) ||
                ( elTablero[2].equals(laLetra) &&
                        elTablero[5].equals(laLetra) &&  elTablero[8].equals(laLetra) ) ||
                ( elTablero[3].equals(laLetra) &&
                        elTablero[6].equals(laLetra) &&  elTablero[9].equals(laLetra) ) ||
                ( elTablero[3].equals(laLetra) &&
                        elTablero[5].equals(laLetra) &&  elTablero[7].equals(laLetra) ) ||
                ( elTablero[1].equals(laLetra) &&
                        elTablero[5].equals(laLetra) &&  elTablero[9].equals(laLetra) ) ;

        return gano;
    }
}

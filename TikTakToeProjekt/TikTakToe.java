package TikTakToeProjekt;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TikTakToe {

    private static String aktuellerSpieler = "X";
    private static int zug = 1;
    private static boolean sieg = false;
    private static boolean unentschieden = false;

    public static String[] array = {
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TikTakToeAnzeigen();

        while (!sieg && !unentschieden) {

            System.out.printf("Spieler %s ist am Zug\nBitte geben sie eine Zahl zwischen 0 und 8 ein%n",
                    aktuellerSpieler);

            int wahl = Eingabepruefen(scanner);

            TikTakToeAnzeigen(wahl);
            pruefeAufSieg();
            if (!sieg && !unentschieden) {
                SpielerWechsel();
            }

        }
        ausgabeErgebnis();
        scanner.close();
    }

    private static void SpielerWechsel() {

        if (aktuellerSpieler.equals("X")) {
            aktuellerSpieler = "O";
        } else {
            aktuellerSpieler = "X";
        }
        zug++;
    }

    private static void TikTakToeAnzeigen(int wahl) {

        array[wahl] = aktuellerSpieler;

        for (int i = 0; i <= 8; i += 3) {
            System.out.printf(" %s | %s | %s\n", array[i], array[i + 1], array[i + 2]);
            if (i < 6) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();

    }

    private static void TikTakToeAnzeigen() {

        for (int i = 0; i <= 8; i += 3) {
            System.out.printf(" %s | %s | %s\n", array[i], array[i + 1], array[i + 2]);
            if (i < 6) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    private static void ausgabeErgebnis() {

        if (unentschieden) {
            System.out.println("unentschieden");
        }
        if (sieg) {
            System.out.printf("Spieler %s hat gewonnen", aktuellerSpieler);
        }
    }

    private static void pruefeAufSieg() {
        // Check for horizontal win
        for (int i = 0; i <= 6; i += 3) {
            if (array[i].equals(aktuellerSpieler) && array[i + 1].equals(aktuellerSpieler)
                    && array[i + 2].equals(aktuellerSpieler)) {
                sieg = true;
                return; // Exit the method early once a winner is found
            }
        }

        // Check for vertical win
        for (int i = 0; i <= 2; i++) {
            if (array[i].equals(aktuellerSpieler) && array[i + 3].equals(aktuellerSpieler)
                    && array[i + 6].equals(aktuellerSpieler)) {
                sieg = true;
                return;
            }
        }

        // Check for diagonal win
        if ((array[0].equals(aktuellerSpieler) && array[4].equals(aktuellerSpieler)
                && array[8].equals(aktuellerSpieler)) ||
                (array[2].equals(aktuellerSpieler) && array[4].equals(aktuellerSpieler)
                        && array[6].equals(aktuellerSpieler))) {
            sieg = true;
        }

        // Check for a tie (no empty spaces left)
        if (zug == 9 && !sieg) {
            unentschieden = true;
        }
    }

    private static int Eingabepruefen(Scanner scanner) {
        int wahl = -1;
        while (wahl == -1) {
            try {
                wahl = scanner.nextInt();
                if (wahl < 0 || wahl > 8) {
                    System.out.println("Bitte nur Zahlen im Bereich von 0-8 eingeben");
                    wahl = -1;
                }
                if (array[wahl].equals("X") || array[wahl].equals("O")) {
                    System.out.println("Dieses Feld ist schon belegt");
                    wahl = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Bitte nur Zahlen von 0-8 eingeben");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Bitte geben sie eine Zahl zwischen 0 und 8 ein");
                scanner.nextLine();
            }
        }
        return wahl;
    }

}

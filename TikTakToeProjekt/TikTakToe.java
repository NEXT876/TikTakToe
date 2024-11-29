package TikTakToeProjekt;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

abstract class TikTakToe {

    protected final Logger logger = Logger.getLogger(TikTakToe.class.getName());
    protected String aktuellerSpieler = "X";
    protected int zug = 1;
    protected boolean sieg = false;
    protected boolean unentschieden = false;

    protected final String[] array = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
    };

    /**
     * public static void main(String[] args) {
     * // Erstelle eine Instanz von TikTakToe
     * TikTakToe game = new TikTakToe();
     * game.startGame();
     * }
     */

    // Neue Methode für den Start des Spiels
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        displayBoard();

        while (!sieg && !unentschieden) {
            logger.info(String.format("Spieler %s ist am Zug. Bitte geben Sie eine Zahl zwischen 1 und 9 ein.", aktuellerSpieler));

            int wahl = eingabepruefen(scanner);
            updateBoard(wahl);

            if (zug >= 5) {
                pruefeAufSieg();
            }
            if (!sieg && !unentschieden) {
                spielerWechsel();
            }
        }
        ausgabeErgebnis();
        scanner.close();
    }

    private void spielerWechsel() {
        if (aktuellerSpieler.equals("X")) {
            aktuellerSpieler = "O";
        } else {
            aktuellerSpieler = "X";
        }
        zug++;
    }

    private void updateBoard(int wahl) {
        array[wahl - 1] = aktuellerSpieler;  // Update the array with the current player's move
        displayBoard();                      // Call the displayBoard method to show the updated board
    }

    private void displayBoard() {
        for (int i = 0; i <= 8; i += 3) {
            System.out.printf(" %s | %s | %s%n", array[i], array[i + 1], array[i + 2]);
            if (i < 6) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    private void ausgabeErgebnis() {
        if (unentschieden) {
            System.out.println("Unentschieden");
        }
        if (sieg) {
            System.out.printf("Spieler %s hat gewonnen", aktuellerSpieler);
        }
    }

    private void pruefeAufSieg() {
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

    abstract int eingabepruefen(Scanner scanner);

}



package TikTakToeProjekt;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


abstract class TikTakToe {

    protected Scanner scanner;
    protected String aktuellerSpieler = "X";
    protected int zug = 1;
    protected boolean sieg = false;
    protected boolean unentschieden = false;
    

    protected final String[] array = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
    };


    protected void startGame() {
        //Scanner scanner = new Scanner(System.in);
        displayBoard();

        while (!sieg && !unentschieden) {
            System.out.printf("Spieler %s ist am Zug.%nBitte geben Sie eine Zahl zwischen 1 und 9 ein.%n", aktuellerSpieler);

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
       // scanner.close();
    }

    protected void spielerWechsel() {
        if (aktuellerSpieler.equals("X")) {
            aktuellerSpieler = "O";
        } else {
            aktuellerSpieler = "X";
        }
        zug++;
    }

    protected void updateBoard(int wahl) {
        array[wahl - 1] = aktuellerSpieler;  // Update the array with the current player's move
        displayBoard();                      // Call the displayBoard method to show the updated board
    }

    protected void displayBoard() {
        for (int i = 0; i <= 8; i += 3) {
            // Prüfe, ob das Feld "X" oder "O" enthält und setze die Farben entsprechend
            String feld1 = array[i].equals("X") ? "\u001B[31mX\u001B[0m" : array[i].equals("O") ? "\u001B[32mO\u001B[0m" : array[i];
            String feld2 = array[i + 1].equals("X") ? "\u001B[31mX\u001B[0m" : array[i + 1].equals("O") ? "\u001B[32mO\u001B[0m" : array[i + 1];
            String feld3 = array[i + 2].equals("X") ? "\u001B[31mX\u001B[0m" : array[i + 2].equals("O") ? "\u001B[32mO\u001B[0m" : array[i + 2];

            // Zeige die Felder an
            System.out.printf(" %s | %s | %s%n", feld1, feld2, feld3);

            // Trennlinie zwischen den Reihen, aber nicht nach der letzten Reihe
            if (i < 6) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    protected void ausgabeErgebnis() {
        if (unentschieden) {
            System.out.println("Unentschieden");
        }
        if (sieg) {
            System.out.printf("Spieler %s hat gewonnen%n", aktuellerSpieler);
        }
    }

    protected void pruefeAufSieg() {
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

    protected int eingabepruefen(Scanner scanner) {
        int wahl = -1;
        while (wahl == -1) {
            try {
                wahl = scanner.nextInt();
                if (wahl < 1 || wahl > 9) {
                    System.out.println("Bitte nur Zahlen im Bereich von 1-9 eingeben");
                    wahl = -1;
                } else if (array[wahl - 1].equals("X") || array[wahl - 1].equals("O")) {
                    System.out.println("Dieses Feld ist schon belegt");
                    wahl = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Bitte nur Zahlen von 1-9 eingeben");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Bitte geben sie eine Zahl zwischen 1 und 9 ein");
                scanner.nextLine();
            }
        }
        return wahl;
    }

}



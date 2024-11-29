package TikTakToeProjekt;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class One_vs_Robot_mode extends TikTakToe {

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        displayBoard();

        while (!sieg && !unentschieden) {
            if (aktuellerSpieler.equals("X")) {
                System.out.printf("Sie sind dran%nBitte geben Sie eine Zahl zwischen 1 und 9 ein.%n");
            }

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

    public int eingabepruefen(Scanner scanner) {
        int wahl = -1;
        if (aktuellerSpieler.equals("O")) {
            while (wahl == -1) {
                wahl = (int) (Math.random() * 9) + 1;

                if (array[wahl - 1].equals("X") || array[wahl - 1].equals("O")) {
                    wahl = -1;
                }
            }
        } else if (aktuellerSpieler.equals("X")) {
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
        }

        return wahl;
    }

    protected void ausgabeErgebnis() {
        if (unentschieden) {
            System.out.println("Unentschieden");
        }
        if (sieg) {
            if (aktuellerSpieler.equals("X")) {
                System.out.println("Sie haben gewonnen");
            } else {
                System.out.println("Sie haben verloren");
            }
        }
    }
}

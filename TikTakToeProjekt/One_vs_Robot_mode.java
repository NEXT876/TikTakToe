package TikTakToeProjekt;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class One_vs_Robot_mode extends TikTakToe {

    public static void main(String[] args) {
    }

    public int eingabepruefen(Scanner scanner) {
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

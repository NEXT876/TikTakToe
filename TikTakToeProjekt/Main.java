package TikTakToeProjekt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nHallo,%nWilkommen zu TikTakToe%n");
        System.out.printf("Bevor wir beginnen bitte waehlen sie einen Spielmodus aus:%nGeben sie 1 ein für den Spielmodus \"1 vs 1\" und 2 um gegen einen Computer zu spielen%n");

        int modus = scanner.nextInt();
        scanner.nextLine();
        if (modus == 1) {
            One_vs_One_mode game = new One_vs_One_mode();
            System.out.printf("Sie haben den Spielmodus 1 gegen 1 gewählt.%nViel Spaß%n");
            game.startGame();
        }
        if (modus == 2) {
            One_vs_Robot_mode game = new One_vs_Robot_mode();
            System.out.printf("Sie haben den Spielmodus gewählt gegen einen Computer zu spielen.%nViel Spaß%n");
            game.startGame();
        }
        scanner.close();
        /*
         System.out.println("Press R to restart or E to close");
         if (scanner.next().equals("R")) {
         main(args);
         } else if (scanner.next().equals("E")) {
         scanner.close();
         System.exit(0);
         }
         */

    }

}
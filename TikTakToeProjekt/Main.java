package TikTakToeProjekt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.printf("%nHallo,%nWilkommen zu TikTakToe%n");
            System.out.printf("Bevor wir beginnen bitte waehlen sie einen Spielmodus aus:%nGeben sie 1 ein für den Spielmodus \"1 vs 1\" und 2 um gegen einen Computer zu spielen%n");

            int modus = moduswahl(scanner);


            if (modus == 1) {
                One_vs_One_mode game = new One_vs_One_mode();
                System.out.printf("Sie haben den Spielmodus 1 gegen 1 gewählt.%nViel Spaß%n");
                game.startGame();
            } else if (modus == 2) {
                One_vs_Robot_mode game = new One_vs_Robot_mode();
                System.out.printf("Sie haben den Spielmodus gewählt gegen einen Computer zu spielen.%nViel Spaß%n");
                game.startGame();
            }
            //
            //play = restart(scanner);
        }
        scanner.close();
    }

    private static int moduswahl(Scanner scanner) {
        int mode = 0;
        while (mode == 0) {
            try {
                mode = scanner.nextInt();
                scanner.nextLine();

                if (mode != 1 && mode != 2) {
                    throw new Exception();
                }
                //scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Bitte wählen sie einen gütligen Modus aus!");
                mode = 0;
                scanner.nextLine();
            }
        }

        return mode;
    }

    private static boolean restart(Scanner scanner) {
        boolean play = false;
        System.out.println("Bitte drücken sie M um zur Modus Auswahl zurück zu kehren");
        System.out.println("Bitte drücken sie R um den aktuellen Modus erneut zu spielen");
        System.out.println("Bitte drücken sie E um das Spiel zu beenden");

        String input = scanner.nextLine().trim().toUpperCase();
        switch (input) {
            case "M", "R": {
                return true;
            }
            case "E": {
                System.exit(0);
            }
            default: {
                System.out.println("Keine Option");
            }

            return play;
        }
    }
}
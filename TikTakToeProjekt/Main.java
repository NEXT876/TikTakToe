package TikTakToeProjekt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Bitte waehlen sie einen Spielmodus aus:%nPress 1 for One vs One and 2 for One vs Robot%n");

        int modus = scanner.nextInt();
        if (modus == 1) {
            One_vs_One_mode game = new One_vs_One_mode();
            game.startGame();
        }
        if (modus == 2) {
            One_vs_Robot_mode game = new One_vs_Robot_mode();
            game.startGame();
        }

    }

}
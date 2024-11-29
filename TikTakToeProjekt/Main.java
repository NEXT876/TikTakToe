package TikTakToeProjekt;

public class Main {

    public static void main(String[] args) {


        System.out.println("Bitte waehlen sie einen Spielmodus aus:%nPress 1 for One vs One and 2 for One vs Robot");

        // Erstelle eine Instanz von TikTakToe
        One_vs_One_mode game = new One_vs_One_mode();
        game.startGame();

    }

}
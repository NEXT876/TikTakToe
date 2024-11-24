package TikTakToeProjekt;

import java.util.Scanner;

public class TikTakToe { 

    
    public static  String aktuellerSpieler = "X";
    public static   int zug = 1;
    public static boolean sieg = false;
    public static boolean unentschieden = false;
 
    public static  String[] array = {
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8"
        };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TikTakToeAnzeigen();

        while(!sieg && !unentschieden){

        System.out.printf("Spieler %s ist am Zug\nBitte gib eine Zahl zwischen 0 und 8 ein", aktuellerSpieler);
        int wahl = scanner.nextInt(); 
        TikTakToeAnzeigen(wahl);
        pruefeAufSieg();
        if(!sieg && !unentschieden){
        SpielerWechsel();
        }
        }

        ausgabeErgebnis();
        scanner.close();
    }

    private static void SpielerWechsel(){

        if(aktuellerSpieler.equals("X")){
            aktuellerSpieler = "O";
        }else{
            aktuellerSpieler = "X";
        }
        zug++;
    }
   
    private static void TikTakToeAnzeigen(int wahl){

        array[wahl] = aktuellerSpieler;
        
    for(int i = 0; i <= 8; i+=3){    
            System.out.printf(" %s | %s | %s\n", array[i], array[i+1], array[i+2]);
    }
    System.out.println();
    }

    private static void TikTakToeAnzeigen(){

        for(int i = 0; i <= 8; i+=3){    
            System.out.printf(" %s | %s | %s\n", array[i], array[i+1], array[i+2]);
    }
    System.out.println();
    }
    
    private static void ausgabeErgebnis(){

        if(unentschieden){
            System.out.println("unentschieden");
        }
        if(sieg){
            System.out.printf("Spieler %s hat gewonnen", aktuellerSpieler);
        }
    }

    private static void pruefeAufSieg() {
        // Check for horizontal win
        for (int i = 0; i <= 6; i += 3) {
            if (array[i].equals(aktuellerSpieler) && array[i + 1].equals(aktuellerSpieler) && array[i + 2].equals(aktuellerSpieler)) {
                sieg = true;
                return;  // Exit the method early once a winner is found
            }
        }
    
        // Check for vertical win
        for (int i = 0; i <= 2; i++) {
            if (array[i].equals(aktuellerSpieler) && array[i + 3].equals(aktuellerSpieler) && array[i + 6].equals(aktuellerSpieler)) {
                sieg = true;
                return;
            }
        }
    
        // Check for diagonal win
        if ((array[0].equals(aktuellerSpieler) && array[4].equals(aktuellerSpieler) && array[8].equals(aktuellerSpieler)) || 
            (array[2].equals(aktuellerSpieler) && array[4].equals(aktuellerSpieler) && array[6].equals(aktuellerSpieler))) {
            sieg = true;
        }
    
        // Check for a tie (no empty spaces left)
        if (zug > 9) {
            unentschieden = true;
        }
    }
    
}

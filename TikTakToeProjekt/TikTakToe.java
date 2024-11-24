package TikTakToeProjekt;

import java.util.Arrays;
import java.util.Scanner;

public class TikTakToe { 

    
    public static  String aktuellerSpieler = "X";
    public static   int zug = 1; 

    public static  String[] array = {
            "0", "1", "2",
            "3", "4", "5",
            "6", "7", "8"
        };

    public static boolean sieg = false;
    public static boolean unentschieden = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TikTakToeAnzeigen();

        while(sieg || unentschieden){

        System.out.printf("Spieler %s ist am Zug\nBitte gib eine Zahl zwischen 0 und 8 ein", aktuellerSpieler);
        int wahl = scanner.nextInt(); 
        TikTakToeAnzeigen(wahl);
        pruefeAufSieg();
        SpielerWechsel(aktuellerSpieler);
       

        }
        ausgabeErgebnis();
        scanner.close();
    }

    private static String SpielerWechsel(String aktuellerSpieler){

        if(aktuellerSpieler.equals("X")){
            aktuellerSpieler = "O";
        }else{
            aktuellerSpieler = "X";
        }
        zug++;
        return aktuellerSpieler;
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
    
    private static void pruefeAufSieg(){
     ///   String arrayZeichen = Arrays.toString(array);

     for(int i = 0; i <= 2; i+=3  ){
        // horizontal
        if(array[i] == array[i+1] && array[i+1] == array[i+2] ||  array[i] == array[i+1] && array[i+1] == array[i+2] || array[i] == array[i+1] && array[i+1] == array[i+2]){
            sieg = true;
        }
    }
    for(int i = 0; i <= 2; i++  ){
        // vertikal
        if(array[i] == array[i+3] && array[i+3] == array[i+6] ||  array[i] == array[i+3] && array[i+3] == array[i+6] || array[i] == array[i+3] && array[i+3] == array[i+6]){
            sieg = true;
        }
    }

    for(int i = 0; i <= 2; i+=3  ){
        // diagonal
        if(array[i] == array[i+4] && array[i+4] == array[i+8] ||  array[i+2] == array[i+4] && array[i+4] == array[i+6]){
            sieg = true;
        }
    }
        if(zug > 9){
            unentschieden = true;
        }

    }
    
    private static void ausgabeErgebnis(){

        if(unentschieden){
            System.out.println("unentschieden");
        }
        if(sieg){
            System.out.printf("Spieler %s hat gewonnen", aktuellerSpieler);
        }
    }
}
